import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MIGRATION_TYPE, REQUEST_TYPE, FILEPATH_COLUMNS } from 'src/app/core/constants/request.constants';
import { YES_OR_NO_OPTIONS } from 'src/app/core/constants/connection.constants';
import { AuthenticationService } from 'src/app/core/services/auth.service';
import { NotificationService } from 'src/app/core/services/notification.service';
import { AppService } from 'src/app/core/services/app.service';
import { FileUpload } from 'primeng/fileupload';

@Component({
    selector: 'app-request',
    templateUrl: './request.component.html',
    styleUrls: ['./request.component.scss']
})


export class RequestComponent implements OnInit {
    breadCrumbItems: Array<{}>;

    migrationTypeOptions: any = [];
    databaseOptions: any = [];

    filePathList: any = [];
    tokenizationFileList: any = [];

    activeTabIndex: number;
    isTokenizationEnabled: any;

    requestModel = {
        "labelName": "",
        "requestType": null, // HIVE TO S3 ,
        "migrationType": null,
        "schemaName": null,
        "migartionFileList": [],
        "tknztnEnabled": YES_OR_NO_OPTIONS.NO,  // Y /N,
        'targetS3Bucket': "",
        "tokenizationFileList": [],
    }

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService,
        private notificationService: NotificationService,
        private appService: AppService
    ) { }

    ngOnInit() {
        this.activeTabIndex = 0;
        this.breadCrumbItems = [{ label: 'Home', path: '/app/home' }, { label: 'Request', active: true }];

        this.isTokenizationEnabled = this.authenticationService.isTokenizationEnabled();

        this.migrationTypeOptions = [
            { label: 'Select Migration Type', value: null },
            { label: 'Full Database', value: MIGRATION_TYPE.FULL_DATABASE },
            { label: 'List of table from speadsheet (csv file)', value: MIGRATION_TYPE.LIST_OF_TABLE_FROM_FILE }
        ];

        this.databaseOptions = [
            { label: 'Select Database', value: null }
        ];
        this.getDatabaseList();
    }

    getDatabaseList() {
        this.appService.getDatabaseNameList().subscribe(
            (res: any) => {
                let databaseOptions = [
                    { label: 'Select Database', value: null }
                ];
                res.forEach((ele) => {
                    databaseOptions.push({
                        "label": ele,
                        "value": ele
                    })
                });
                this.databaseOptions = databaseOptions;

                if (this.appService.isRequestBackClicked) {
                    this.requestModel = Object.assign({}, this.appService.requestModel)
                }
                this.appService.isRequestBackClicked = false;
                this.appService.requestModel = undefined;
                this.appService.requestPreviewList = [];
            },
            (error) => {
                this.notificationService.showError(error || "System Temporarly unavailable");
            });
    }

    getDataRecordsArrayFromCSVFile(csvRecordsArray: any, headerLength: any) {
        var dataArr = [];
        csvRecordsArray.forEach((row, index) => {
            if (index > 0) {
                let data = row.split(',');
                if (data.length == headerLength) {
                    let csvRecord = {
                        sno: data[0],
                        dbName: data[1],
                        tableName: data[2],
                        filterCondition: data[3],
                        targetBucketName: data[4],
                        incrementalFlag: data[5],
                        incrementalColumn: data[6]
                    }
                    dataArr.push(csvRecord);
                }
            }
        });
        return dataArr;
    }

    getHeaderArray(csvRecordsArr: any) {
        let headers = csvRecordsArr[0].split(',');
        let headerArray = [];
        headers.forEach((header) => {
            headerArray.push(header);
        });
        return headerArray;
    }

    fileSelectHandler(event, fileUploadRef: FileUpload) {
        let files = event.files;
        if (files.length > 0) {
            this.filePathList.push(files[0]);

            var reader = new FileReader();
            reader.readAsText(files[0]);

            reader.onload = (data) => {
                let csvData: any = reader.result;
                let csvRecordsArray = csvData.split(/\r\n|\n/);
                let headersRow = this.getHeaderArray(csvRecordsArray);
                let csvRecords = this.getDataRecordsArrayFromCSVFile(csvRecordsArray, headersRow.length);
                console.log(csvRecords);
            }
            reader.onerror = () => {
                this.notificationService.showError("Error while uploading the data");
                fileUploadRef.clear();
            };
        }
    }

    tokenizationFileSelectHandler(event, fileUploadRef) {
        let files = event.files;
        if (files.length > 0) {
            this.tokenizationFileList.push(files[0]);
        }
    }

    handleChange(e) {
        this.activeTabIndex = e.index;
    }

    validateRequestModel() {
        if (this.requestModel.labelName.length < 1) {
            this.notificationService.showError('Please enter label name');
            return false;
        }

        else if (this.requestModel.migrationType == null) {
            this.notificationService.showError('Please select Migration Type');
            return false;
        }
        else if (this.requestModel.migrationType == MIGRATION_TYPE.FULL_DATABASE || this.requestModel.migrationType == MIGRATION_TYPE.LIST_OF_TABLE_FROM_FILE) {
            if (this.requestModel.migrationType == MIGRATION_TYPE.FULL_DATABASE) {
                if (this.requestModel.schemaName == null) {
                    this.notificationService.showError('Please select database name');
                    return false;
                }
                else if (this.requestModel.targetS3Bucket.length < 1) {
                    this.notificationService.showError('Please enter target s3 bucket');
                    return false;
                }
            }
            else if (this.requestModel.migrationType == MIGRATION_TYPE.LIST_OF_TABLE_FROM_FILE) {
                if (this.filePathList.length < 1) {
                    this.notificationService.showError('Please select file path');
                    return false;
                }
            }
            else if (this.requestModel.tknztnEnabled == 'Y' && this.tokenizationFileList.length < 1) {
                this.notificationService.showError('Please select Tokenization File Path');
                return false;
            }
            return true;
        }
        else {
            return false
        }

    }

    onMigrationTypeChange($event, fileUploadRef: any, tokenizefileUploadRef: any) {
        this.requestModel["schemaName"] = null;
        this.requestModel["migartionFileList"] = [];
        this.requestModel["tknztnEnabled"] = YES_OR_NO_OPTIONS.NO;
        this.requestModel['targetS3Bucket'] = "";
        this.requestModel["tokenizationFileList"] = [];

        this.filePathList = [];
        this.tokenizationFileList = [];

        if (fileUploadRef) {
            fileUploadRef.clear();
        }
        if (tokenizefileUploadRef) {
            tokenizefileUploadRef.clear();
        }
    }

    cancelConnection() {
        this.requestModel = {
            "labelName": "",
            "requestType": null, // HIVE TO S3 ,
            "migrationType": null,
            "schemaName": null,
            "migartionFileList": [],
            "tknztnEnabled": YES_OR_NO_OPTIONS.NO,  // Y /N,
            'targetS3Bucket': "",
            "tokenizationFileList": [],
        }
    }

    onContinueFunction() {
        if (this.validateRequestModel()) {
            switch (this.activeTabIndex) {
                case 0:
                    this.requestModel.requestType = REQUEST_TYPE.HIVE_TO_S3;
                    break;
                case 1:
                    this.requestModel.requestType = REQUEST_TYPE.TERADATA_TO_S3;
                    break;
                case 2:
                    this.requestModel.requestType = REQUEST_TYPE.TERADATA_TO_RED_SHIFT;
                    break;
                case 3:
                    this.requestModel.requestType = REQUEST_TYPE.TERADATA_TO_SNOWFLAKE;
                    break;
                default:
                    break;
            }
            this.appService.getRequestPreviewData(this.requestModel).subscribe(
                (res: any) => {
                    if (res.length > 0) {
                        this.appService.requestModel = this.requestModel;
                        res.forEach(item => {
                            item["targetS3Bucket"] = item["tableName"] + "/" + item["targetS3Bucket"];
                            console.log(item["targetS3Bucket"]);
                        });

                        this.appService.requestPreviewList = res;
                        this.router.navigate(['/app/request/preview']);
                    }
                    else {
                        this.notificationService.showError("No data found for the selected database");
                    }
                },
                (error) => {
                    this.notificationService.showError(error || "Error while saving request info");
                });
        }
    }
}
