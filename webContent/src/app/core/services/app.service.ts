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

    addUser(userModel: any) {
        return this.http.post(`${environment.apiUrl}/users/save`, userModel);
    }

    updateUser(userModel: any) {
        return this.http.post(`${environment.apiUrl}/users/save`, userModel);
    }

    deleteUser(userId: any) {
        return this.http.delete(`${environment.apiUrl}/users/delete/${userId}`);
    }

    resetPassword(password: any) {
        const params = {
            "id": this.authenticationService.currentUser()["id"],
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

    getAllUsers(): any {
        return this.http.get(`${environment.apiUrl}/users/all`);
    }

    getHistoryMainList() {
        return this.http.get(`${environment.apiUrl}/history/main/all`);
    }

    getHistoryDetailsById(requestNumber: any) {
        return this.http.get(`${environment.apiUrl}/history/all/${requestNumber}`);
    }

    testConnection(connectionModel: any) {
        return this.http.post(`${environment.apiUrl}/connection/validate`, connectionModel);
    }

    saveConnection(connectionModel: any) {
        return this.http.post(`${environment.apiUrl}/connection/save`, connectionModel);
    }

}