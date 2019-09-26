import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from 'src/app/core/services/app.service';
import { NotificationService } from 'src/app/core/services/notification.service';
import { ConfirmationService } from 'primeng/api';

@Component({
    selector: 'app-basket',
    templateUrl: './basket.component.html',
    styleUrls: ['./basket.component.scss'],
    providers: []
})

export class BasketComponent implements OnInit {
    // bread crum data
    breadCrumbItems: Array<{}>;

    tableCols: any[];
    tableData: any = [];

    constructor(
        private router: Router,
        private appService: AppService,
        private notificationService: NotificationService,
        private confirmationService: ConfirmationService
    ) { }

    ngOnInit() {
        // tslint:disable-next-line: max-line-length
        this.breadCrumbItems = [{ label: 'Home', path: '/app/home' }, { label: 'Basket', active: true }];

        /**
         * fetch data
         */
        this._fetchData();
        this.tableCols = [
            { field: 'srNo', header: 'Sr.No' },
            { field: 'schemaName', header: 'DB Name' },
            { field: 'tableName', header: 'Table Name' },
            { field: 'filterCondition', header: 'Filter Condition' },
            { field: 'targetS3Bucket', header: 'Target Bucket Name' },
            { field: 'incrementalFlag', header: 'Incremental Flag' },
            { field: 'incrementalClmn', header: 'Incremental Column' }
        ];
    }

    /**
     * fetches the table value
     */
    _fetchData() {
        this.appService.getAllBasketItems().subscribe(
            data => {
                if (data.length > 0) {
                    this.tableData = data;
                    this.appService.basketCountSubscription.next(data.length);
                }
                else {
                    this.notificationService.showError('No Data found in the basket');
                    this.router.navigate(['/app/request']);
                }
            },
            error => {
                console.log(error);
            });
    }

    onCancelFunction() {
        this.appService.clearAllBasketItems().subscribe(
            (res: any) => {
                this.appService.basketCountSubscription.next(0);
                this.notificationService.showSuccess("Basket items cleared successfully ");
                this.router.navigate(['/app/request']);
            },
            (error) => {
                this.notificationService.showError(error || "System Temporarly unavailable");
            });
    }

    onContinueFunction() {
        this.appService.saveBasketData(this.tableData).subscribe(
            (res: any) => {
                this.appService.basketCountSubscription.next(0);
                this.router.navigate(['/app/history']);
                this.notificationService.showSuccess("Data saved successfully to basket");
            },
            (error) => {
                this.notificationService.showError(error || "Error while saving basket info");
            });
    }

    clearClickFunction() {
        this.confirmationService.confirm({
            message: 'Are you sure want to delete the items?',
            accept: () => {
                this.onCancelFunction();
            }
        });
    }
}
