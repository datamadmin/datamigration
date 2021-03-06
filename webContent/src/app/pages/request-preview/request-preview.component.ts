import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from 'src/app/core/services/app.service';
import { NotificationService } from 'src/app/core/services/notification.service';
import { AuthenticationService } from 'src/app/core/services/auth.service';

@Component({
    selector: 'app-request-preview',
    templateUrl: './request-preview.component.html',
    styleUrls: ['./request-preview.component.scss'],
    providers: []
})

export class RequestPreviewComponent implements OnInit, OnDestroy {
    // bread crum data
    breadCrumbItems: Array<{}>;

    previewCols: any[];
    previewList: any = [];
    selectedRequestList: any = [];

    requestModel: any;

    constructor(
        private router: Router,
        private appService: AppService,
        private notificationService: NotificationService,
        private authenticationService: AuthenticationService
    ) { }

    ngOnDestroy() {
        this.appService.basketCountSubscription.next(0);
    }

    ngOnInit() {
        if (this.appService.requestModel && this.appService.requestPreviewList.length > 0) {
            this.requestModel = this.appService.requestModel;
            this.previewList = this.appService.requestPreviewList;

            this.previewList.forEach((item: any) => {
                item["targetS3Bucket"] = this.requestModel["targetS3Bucket"];
                item["incrementalFlag"] = "N";
                item["incrementalClmn"] = null;
                item["labelName"] = this.requestModel["labelName"];
                item["targetS3Bucket"] = item["targetS3Bucket"] + "/" + item["tableName"];
            });

            // tslint:disable-next-line: max-line-length
            this.breadCrumbItems = [
                { label: 'Home', path: '/app/home' },
                { label: 'Request', path: '/app/request', active: true },
                { label: this.requestModel.requestType, active: true },
                { label: this.requestModel.migrationType, active: true },
                { label: this.requestModel.schemaName, active: true }
            ];

            this.previewCols = [
                { field: 'srNo', header: 'Sr.No', width: '100px' },
                { field: 'schemaName', header: 'DB Name', width: '180px' },
                { field: 'tableName', header: 'Table Name', width: '180px' },
                { field: 'filterCondition', header: 'Filter Condition', width: '180px' },
                { field: 'targetS3Bucket', header: 'Target Bucket Name', width: '100px' },
                { field: 'incrementalFlag', header: 'Incremental Flag', width: '100px' },
                { field: 'incrementalClmn', header: 'Incremental Column', width: '100px' }
            ];
        }
        else {
            this.onCancelFunction();
        }
    }

    onCancelFunction() {
        this.appService.requestModel = undefined;
        this.appService.requestPreviewList = [];
        this.appService.isRequestBackClicked = true;
        this.appService.basketCountSubscription.next(0);
        this.router.navigate(['/app/request']);
    }



    onContinueFunction() {
        if (this.selectedRequestList.length > 0) {

            this.selectedRequestList.forEach(item => {
                item["userId"] = this.appService.getCurrentUserName();
                item["addtoBasket"] = true;
                item["requestType"] = this.requestModel["requestType"];
            });

            this.appService.saveRequestPreviewData(this.selectedRequestList).subscribe(
                (res: any) => {
                    this.appService.requestModel = undefined;
                    this.appService.requestPreviewList = [];
                    this.notificationService.showSuccess("Data saved successfully to basket");
                    this.router.navigate(['/app/basket']);
                },
                (error) => {
                    this.notificationService.showError(error || "Error while saving request info");
                });
        }
        else {
            this.notificationService.showError("Please select atleast one record");
        }
    }

    onRowSelectionChange(event) {
        this.appService.basketCountSubscription.next(this.selectedRequestList.length);
    }

}
