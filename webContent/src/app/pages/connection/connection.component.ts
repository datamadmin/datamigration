import { Component, OnInit } from '@angular/core';
import { AppService } from 'src/app/core/services/app.service';
import { NotificationService } from 'src/app/core/services/notification.service';

enum CONNECTION_GROUP {
    AWS_TO_S3 = "AWS_TO_S3",
    HDFS = "HDFS",
    TARGET_FILE_PROPS = "TARGET_FILE_PROPS",
    OTHER_PROPS = "OTHER_PROPS"
}

@Component({
    selector: 'app-connection',
    templateUrl: './connection.component.html',
    styleUrls: ['./connection.component.scss']
})


export class ConnectionComponent implements OnInit {

    breadCrumbItems: Array<{}>;

    awsToS3ConnectionFlag: boolean = false;
    hdfsConnectionFlag: boolean = false;

    constructor(
        private appService: AppService,
        private notificationService: NotificationService
    ) { }


    private connectionModel = {
        "connectionType": "",
        "awsAccessIdLc": "",
        "awsSecretKeyLc": "",
        "awsAccessIdSc": "",
        "awsSecretKeySc": "",
        "roleArn": "",
        "principalArn": "",
        "samlProviderArn": "",
        "roleSesnName": "",
        "policyArnMembers": "",
        "externalId": "",
        "fdrtdUserName": "",
        "inlineSesnPolicy": "",
        "duration": "",
        "ldapUserName": "",
        "ldapUserPassw": "",
        "ldapDomain": "",
        "scCrdntlAccessType": "",
        "isHiveConnEnabled": false,
        "isImpalaConnEnabled": false,
        "isSparkConnEnabled": false,
        "hiveHostName": "",
        "hivePortNmbr": "",
        "impalaHostName": "",
        "impalaPortNmbr": "",
        "sqlWhDir": "",
        "hiveMsUri": "",
        "authenticationType": "",
        "credentialStrgType": "",
        "hdfsLdapUserName": "",
        "hdfsLdapUserPassw": "",
        "hdfsLdapDomain": "",
        "kerberosHostRealm": "",
        "kerberosHostFqdn": "",
        "kerberosServiceName": "",
        "sslKeystorePath": "",
        "tgtFormatPropDto": {
            "formatType": "",
            "compressionType": "",
            "fieldDelimiter": ""
        },
        "tgtOtherPropDto": {
            "parallelJobs": "",
            "parallelUsrRqst": "",
            "tempHiveDB": "",
            "tempHdfsDir": "",
            "hdfcEdgeNode": "",
            "hdfsUserName": "",
            "hdfsPemLocation": "",
            "tokenizationInd": "",
            "ptgyDirPath": ""
        }
    }

    ngOnInit() {
        this.breadCrumbItems = [{ label: 'Home', path: '/app/home' }, { label: 'Settings', active: true }, { label: 'Connection', active: true }];
    }

    cancelConnection(connectionGroup: CONNECTION_GROUP) {
        switch (connectionGroup) {
            case CONNECTION_GROUP.AWS_TO_S3:
                break;
            case CONNECTION_GROUP.HDFS:
                break;
            case CONNECTION_GROUP.TARGET_FILE_PROPS:
                break;
            case CONNECTION_GROUP.OTHER_PROPS:
                break;
            default:
                break;
        }
    }

    validateConnectionDetails(connectionGroup: CONNECTION_GROUP) {
        let isConnectionValid = false;
        switch (connectionGroup) {
            case CONNECTION_GROUP.AWS_TO_S3:
                isConnectionValid = true;
                break;
            case CONNECTION_GROUP.HDFS:
                isConnectionValid = true;
                break;
            case CONNECTION_GROUP.TARGET_FILE_PROPS:
                isConnectionValid = true;
                break;
            case CONNECTION_GROUP.OTHER_PROPS:
                isConnectionValid = true;
                break;
            default:
                isConnectionValid = false;
                break;
        }
        return isConnectionValid;
    }

    markConnectionFlag(connectionGroup: CONNECTION_GROUP, status) {
        switch (connectionGroup) {
            case CONNECTION_GROUP.AWS_TO_S3:
                this.awsToS3ConnectionFlag = status;
                break;
            case CONNECTION_GROUP.HDFS:
                this.hdfsConnectionFlag = status;
                break;
            default:
                break;
        }
    }

    testConnection(connectionGroup: CONNECTION_GROUP) {
        if (this.validateConnectionDetails(connectionGroup)) {
            this.appService.testConnection(this.connectionModel).subscribe((res) => {
                this.markConnectionFlag(connectionGroup, true);
                this.notificationService.showSuccess('Test connection successfull');
            }, (error) => {
                this.markConnectionFlag(connectionGroup, false);
                this.notificationService.showError(error || 'System Temporarly Unavailable . Please try again');
            });
        }
    }

    saveConnection(connectionGroup) {
        if (this.validateConnectionDetails(connectionGroup)) {
            this.appService.saveConnection(this.connectionModel).subscribe((res) => {
                this.notificationService.showSuccess('Connection saved successfull');
            }, (error) => {
                this.notificationService.showError(error || 'System Temporarly Unavailable . Please try again');
            });
        }
    }

}
