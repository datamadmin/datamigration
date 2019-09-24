import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from 'src/app/core/services/app.service';
import { NotificationService } from 'src/app/core/services/notification.service';

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
        private notificationService: NotificationService
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
                this.tableData = data;
            },
            error => {
                console.log(error);
            });
    }

    onCancelFunction() {
        this.router.navigate(['/app/request']);
    }

    onContinueFunction() {
        this.router.navigate(['/app/history']);
    }

    clearClickFunction() {
        this.appService.clearAllBasketItems().subscribe(
            (res: any) => {
                this.tableData = [];
                this.notificationService.showSuccess("Basket items cleared successfully ");
                setTimeout(() => {
                    this._fetchData();
                }, 10);
            },
            (error) => {
                this.notificationService.showError(error || "System Temporarly unavailable");
            });
    }
}
