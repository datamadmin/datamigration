import { Component, OnInit } from '@angular/core';
import { AppService } from 'src/app/core/services/app.service';
import { NotificationService } from 'src/app/core/services/notification.service';
import { AuthenticationService } from 'src/app/core/services/auth.service';
import {
    CONNECTION_TYPE,
    AUTHENTICATION_TYPE,
    FORMAT_TYPE,
    COMPRESSION_TYPE,
    YES_OR_NO_OPTIONS,
    CONNECTION_GROUP,
    SC_CREDENTIALS_ACCESS_TYPE,
    CREDENTIAL_STORAGE_TYPE
} from 'src/app/core/constants/connection.constants';

@Component({
    selector: 'app-connection',
    templateUrl: './connection.component.html',
    styleUrls: ['./connection.component.scss']
})

export class ConnectionComponent implements OnInit {

    breadCrumbItems: Array<{}>;

    awsToS3ConnectionFlag: boolean = false;
    hdfsConnectionFlag: boolean = false;
    isAdmin: boolean = false;

    constructor(
        private appService: AppService,
        private notificationService: NotificationService,
        private authenticationService: AuthenticationService
    ) { }


    private connectionModel = {
        "connectionGroup": "",
        "connectionType": CONNECTION_TYPE.DIRECT_HDFS,
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
        "duration": 3600,
        "ldapUserName": "",
        "ldapUserPassw": "",
        "ldapDomain": "",
        "scCrdntlAccessType": SC_CREDENTIALS_ACCESS_TYPE.ASSUME,
        "isHiveConnEnabled": false,
        "isImpalaConnEnabled": false,
        "isSparkConnEnabled": false,
        "hiveHostName": "",
        "hivePortNmbr": "",
        "impalaHostName": "",
        "impalaPortNmbr": "",
        "sqlWhDir": "",
        "hiveMsUri": "",
        "authenticationType": AUTHENTICATION_TYPE.UNSECURED,
        "credentialStrgType": "",
        "hdfsLdapUserName": "",
        "hdfsLdapUserPassw": "",
        "hdfsLdapDomain": "",
        "kerberosHostRealm": "",
        "kerberosHostFqdn": "",
        "kerberosServiceName": "",
        "sslKeystorePath": "",
        "tgtFormatPropTempDto": {
            "formatType": FORMAT_TYPE.SOURCE,
            "compressionType": COMPRESSION_TYPE.SOURCE,
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
            "tokenizationInd": YES_OR_NO_OPTIONS.NO,
            "ptgyDirPath": ""
        }
    }

    ngOnInit() {
        this.breadCrumbItems = [{ label: 'Home', path: '/app/home' }, { label: 'Settings', active: true }, { label: 'Connection', active: true }];
        this.isAdmin = this.authenticationService.currentUser()["userRole"] === 'Admin' ? true : false;
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
        if (connectionGroup === CONNECTION_GROUP.AWS_TO_S3) {
            if (this.connectionModel.connectionType === CONNECTION_TYPE.DIRECT_LC) {
                if (this.connectionModel.awsAccessIdLc.length < 1) {
                    this.notificationService.showError("AWS Access ID is mandatory");
                    return false;
                }
                else if (this.connectionModel.awsSecretKeyLc.length < 1) {
                    this.notificationService.showError("AWS Secret Key is mandatory");
                    return false;
                }
            }

            else if (this.connectionModel.connectionType === CONNECTION_TYPE.DIRECT_SC) {
                if (this.connectionModel.scCrdntlAccessType === SC_CREDENTIALS_ACCESS_TYPE.ASSUME) {
                    if (this.connectionModel.awsAccessIdSc.length < 1) {
                        this.notificationService.showError("AWS Access ID is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.awsSecretKeySc.length < 1) {
                        this.notificationService.showError("AWS Secret Key is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.roleArn.length < 1) {
                        this.notificationService.showError("Role ARN is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.roleSesnName.length < 1) {
                        this.notificationService.showError("Role Session Name is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.inlineSesnPolicy.length < 1) {
                        this.notificationService.showError("Inline Session Policy is mandatory");
                        return false;
                    }
                }
                else if (this.connectionModel.scCrdntlAccessType === SC_CREDENTIALS_ACCESS_TYPE.ASSUME_SAML) {
                    if (this.connectionModel.ldapUserName.length < 1) {
                        this.notificationService.showError("LDAP User Name is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.ldapUserPassw.length < 1) {
                        this.notificationService.showError("LDAP User Password is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.ldapDomain.length < 1) {
                        this.notificationService.showError("LDAP Domain is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.samlProviderArn.length < 1) {
                        this.notificationService.showError("SAML Provider ARN is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.principalArn.length < 1) {
                        this.notificationService.showError("Principal ARN is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.roleArn.length < 1) {
                        this.notificationService.showError("Role ARN is mandatory");
                        return false;
                    }
                }
                else if (this.connectionModel.scCrdntlAccessType === SC_CREDENTIALS_ACCESS_TYPE.AWS_FEDERATED_USER) {
                    if (this.connectionModel.fdrtdUserName.length < 1) {
                        this.notificationService.showError("Federated User Name is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.awsAccessIdSc.length < 1) {
                        this.notificationService.showError("AWS Access ID is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.awsSecretKeySc.length < 1) {
                        this.notificationService.showError("AWS Secret Key is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.inlineSesnPolicy.length < 1) {
                        this.notificationService.showError("Inline Session Policy is mandatory");
                        return false;
                    }
                }
            }
        }

        else if (connectionGroup === CONNECTION_GROUP.HDFS) {
            if (this.connectionModel.isHiveConnEnabled || this.connectionModel.isImpalaConnEnabled || this.connectionModel.isSparkConnEnabled) {
                if (this.connectionModel.isHiveConnEnabled) {
                    if (this.connectionModel.hiveHostName.length < 1) {
                        this.notificationService.showError("Hive Host Name is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.hivePortNmbr.length < 1) {
                        this.notificationService.showError("Hive Port Number is mandatory");
                        return false;
                    }
                }

                if (this.connectionModel.isImpalaConnEnabled) {
                    if (this.connectionModel.impalaHostName.length < 1) {
                        this.notificationService.showError("Impala Host Name is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.impalaPortNmbr.length < 1) {
                        this.notificationService.showError("Impala Port Number is mandatory");
                        return false;
                    }
                }

                if (this.connectionModel.isSparkConnEnabled) {
                    if (this.connectionModel.sqlWhDir.length < 1) {
                        this.notificationService.showError("SQL Warehouse Dir is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.hiveMsUri.length < 1) {
                        this.notificationService.showError("Hive Metastore URI is mandatory");
                        return false;
                    }
                }
            }
            else {
                this.notificationService.showError("Please select atleast one connection");
                return false;
            }


            if (this.connectionModel.credentialStrgType === CREDENTIAL_STORAGE_TYPE.LDAP || this.connectionModel.credentialStrgType === CREDENTIAL_STORAGE_TYPE.KERBEROS) {
                if (this.connectionModel.credentialStrgType === CREDENTIAL_STORAGE_TYPE.LDAP) {
                    if (this.connectionModel.ldapUserName.length < 1) {
                        this.notificationService.showError("LDAP User Name is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.ldapUserPassw.length < 1) {
                        this.notificationService.showError("LDAP Password URI is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.ldapDomain.length < 1) {
                        this.notificationService.showError("LDAP Domain is mandatory");
                        return false;
                    }
                }
                else if (this.connectionModel.credentialStrgType === CREDENTIAL_STORAGE_TYPE.KERBEROS) {
                    if (this.connectionModel.kerberosHostRealm.length < 1) {
                        this.notificationService.showError("Host Realm is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.kerberosHostFqdn.length < 1) {
                        this.notificationService.showError("Host FQDN is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.kerberosServiceName.length < 1) {
                        this.notificationService.showError("Service Name is mandatory");
                        return false;
                    }
                    else if (this.connectionModel.sslKeystorePath.length < 1) {
                        this.notificationService.showError("SSL Keystore Path is mandatory");
                        return false;
                    }
                }
            }
            else {
                this.notificationService.showError("Please select authentication storage type");
                return false;
            }
        }

        else if (connectionGroup === CONNECTION_GROUP.TARGET_FILE_PROPS) {
            if (this.connectionModel.tgtFormatPropTempDto.formatType == FORMAT_TYPE.TEXT) {
                if (this.connectionModel.tgtFormatPropTempDto.fieldDelimiter.length < 1) {
                    this.notificationService.showError("Field Delimiter is mandatory");
                    return false;
                }
            }
        }

        else if (connectionGroup === CONNECTION_GROUP.OTHER_PROPS) {

        }
        else {

        }
        return true;
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
            this.connectionModel.connectionGroup = connectionGroup;
            this.appService.testConnection(this.connectionModel).subscribe((res) => {
                this.markConnectionFlag(connectionGroup, true);
                this.notificationService.showSuccess('Test connection successfull');
            }, (error) => {
                console.log(error);
                this.markConnectionFlag(connectionGroup, false);
                this.notificationService.showError(error || 'System Temporarly Unavailable . Please try again');
            });
        }
    }

    saveConnection(connectionGroup) {
        if (this.validateConnectionDetails(connectionGroup)) {
            this.connectionModel.connectionGroup = connectionGroup;
            this.appService.saveConnection(this.connectionModel).subscribe((res) => {
                this.markConnectionFlag(connectionGroup, false);
                this.notificationService.showSuccess('Connection saved successfully');
            }, (error) => {
                this.notificationService.showError(error || 'System Temporarly Unavailable . Please try again');
            });
        }
    }

}

