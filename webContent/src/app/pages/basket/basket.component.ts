import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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

    constructor(private router: Router) { }

    ngOnInit() {
        // tslint:disable-next-line: max-line-length
        this.breadCrumbItems = [{ label: 'Home', path: '/app/home' }, { label: 'Basket', active: true }];

        /**
         * fetch data
         */
        this._fetchData();

        this.tableCols = [
            { field: 'sno', header: 'Sr.No' },
            { field: 'dbName', header: 'DB Name' },
            { field: 'tableName', header: 'Table Name' },
            { field: 'filterCondition', header: 'Filter Condition' },
            { field: 'targetBucketName', header: 'Target Bucket Name' },
            { field: 'incrementalFlag', header: 'Incremental Flag' },
            { field: 'incrementalColumn', header: 'Incremental Column' }
        ];
    }

    /**
     * fetches the table value
     */
    _fetchData() {
        this.tableData = [{
            sno: '1',
            dbName: 'DB1',
            tableName: "Table1",
            filterCondition: 'Sample Condition',
            targetBucketName: 'Bucket1',
            incrementalFlag: false,
            incrementalColumn: "Col1"
        },
        {
            sno: '2',
            dbName: 'DB1',
            tableName: "Table2",
            filterCondition: 'Sample Condition',
            targetBucketName: 'Bucket1',
            incrementalFlag: false,
            incrementalColumn: "Col1"
        },
        {
            sno: '3',
            dbName: 'DB1',
            tableName: "Table3",
            filterCondition: 'Sample Condition',
            targetBucketName: 'Bucket1',
            incrementalFlag: false,
            incrementalColumn: "Col1"
        }]
    }

    onCancelFunction() {
        this.router.navigate(['/app/request']);
    }

    onContinueFunction() {
        this.router.navigate(['/app/history']);
    }
}
