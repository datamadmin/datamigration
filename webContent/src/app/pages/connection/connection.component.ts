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

    cancelConnection(connectionGroup) {

    }

    testConnection(connectionGroup: CONNECTION_GROUP) {
        switch (connectionGroup) {
            case CONNECTION_GROUP.AWS_TO_S3:
                this.appService.testConnection(this.connectionModel).subscribe((res) => {
                    this.notificationService.showSuccess('Test connection successfull');
                }, (error) => {
                    this.notificationService.showError('System Temporarly Unavailable . Please try again');
                });
                break;

            default:
                break;
        }
    }

    saveConnection(connectionGroup) {

    }


}
