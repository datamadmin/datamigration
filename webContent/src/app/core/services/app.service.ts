import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { CookieService } from '../services/cookie.service';

import { environment } from 'src/environments/environment';
import { AuthenticationService } from './auth.service';

@Injectable({ providedIn: 'root' })
export class AppService {
    constructor(
        private http: HttpClient,
        private cookieService: CookieService,
        private authenticationService: AuthenticationService
    ) { }

    private getCurrentUserId(): any {
        let currentUserId = this.authenticationService.currentUser()["id"];
        console.log(currentUserId);
        return currentUserId;
    }

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

    getAllBasketItems(): any {
        return this.http.get(`${environment.apiUrl}/basket/all`);
    }

    clearAllBasketItems(): any {
        return this.http.delete(`${environment.apiUrl}/basket/delete/${this.getCurrentUserId()}`);
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

}