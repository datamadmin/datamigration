import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { CookieService } from '../services/cookie.service';

import { environment } from 'src/environments/environment';
import { AuthenticationService } from './auth.service';
import { BehaviorSubject } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AppService {
    constructor(
        private http: HttpClient,
        private cookieService: CookieService,
        private authenticationService: AuthenticationService
    ) { }

    getCurrentUserId(): any {
        let currentUserId = this.authenticationService.currentUser()["id"];
        return currentUserId;
    }

    requestModel: any;
    requestPreviewList: any = [];
    isRequestBackClicked: boolean = false;

    public basketCountSubscription = new BehaviorSubject(0);

    addUser(userModel: any) {
        return this.http.post(`${environment.apiUrl}/users/save`, userModel);
    }

    updateUser(userModel: any) {
        return this.http.post(`${environment.apiUrl}/users/edit`, userModel);
    }

    deleteUser(userId: any) {
        const params = {
            "userId": userId
        }
        return this.http.get(`${environment.apiUrl}/users/delete`, { params });
    }

    resetPassword(password: any) {
        const params = {
            "id": this.getCurrentUserId(),
            "password": password
        }
        return this.http.get(`${environment.apiUrl}/users/resetPassword`, { params });
    }

    forgotPassword(userName: any, emailid: any) {
        const params = {
            "userName": userName,
            "emailid": emailid
        }
        return this.http.get(`${environment.apiUrl}/users/forgotPassword`, { params });
    }


    getAllUsers(): any {
        return this.http.get(`${environment.apiUrl}/users/all`);
    }

    getHistoryMainList() {
        return this.http.get(`${environment.apiUrl}/history/main/all`);
    }

    getHistoryDetailsById(requestNo: any) {
        return this.http.get(`${environment.apiUrl}/history/all/${requestNo}`);
    }

    getReconMainList() {
        return this.http.get(`${environment.apiUrl}/recon/all`);
    }

    getReconDetailsById(requestNo: any) {
        return this.http.get(`${environment.apiUrl}/recon/detail/details/${requestNo}`);
    }

    testConnection(connectionModel: any) {
        return this.http.post(`${environment.apiUrl}/connection/validate`, connectionModel);
    }

    saveConnection(connectionModel: any) {
        return this.http.post(`${environment.apiUrl}/connection/save`, connectionModel);
    }

    getConnectionDetails() {
        return this.http.get(`${environment.apiUrl}/connection/get`);
    }

    getDatabaseNameList() {
        return this.http.get(`${environment.apiUrl}/request/all`);
    }

    getRequestPreviewData(requestModel: any) {
        return this.http.get(`${environment.apiUrl}/request/all/${requestModel.schemaName}`);
    }

    saveRequestPreviewData(basketList: any) {
        let headers = new HttpHeaders({
            'userId': this.getCurrentUserId()
        });
        return this.http.post(`${environment.apiUrl}/basket/save`, basketList, { headers: headers });
    }

    getAllBasketItems(): any {
        return this.http.get(`${environment.apiUrl}/basket/all`);
    }

    saveBasketData(basketList: any) {
        let headers = new HttpHeaders({
            'userId': this.getCurrentUserId()
        });
        return this.http.post(`${environment.apiUrl}/basket/save/purge`, basketList, { headers: headers });
    }

    clearAllBasketItems(): any {
        let headers = new HttpHeaders({
            'userId': this.getCurrentUserId()
        });
        return this.http.get(`${environment.apiUrl}/basket/clear`, { headers: headers });
    }

    cancelAllBasketItems(): any {
        return this.http.delete(`${environment.apiUrl}/basket/delete/${this.getCurrentUserId()})}`);
    }

    getHomeScreenData() {
        return this.http.get(`${environment.apiUrl}/home/status`);
    }
}