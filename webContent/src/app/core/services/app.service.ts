import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { CookieService } from '../services/cookie.service';

import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class AppService {
    constructor(private http: HttpClient, private cookieService: CookieService) { }

    login(email: string, password: string) {
        return this.http.post<any>(`/api/login`, { email, password });
    }
    logout() {
        // remove user from local storage to log user out
        this.cookieService.deleteCookie('currentUser');
    }

    getAllBasketItems(): any {
        return this.http.get(`${environment.apiUrl}/basket/all`);
    }

    getAllUsers(): any {
        return this.http.get(`${environment.apiUrl}/users/all`);
    }

    getHistoryList() {

    }

    addUser(userModel: any) {
        return this.http.post(`${environment.apiUrl}/users/save`, userModel);
    }

    updateUser(userModel: any) {
        return this.http.post(`${environment.apiUrl}/users/save`, userModel);
    }

    deleteUser(userId: any) {
        let params = new HttpParams();
        params = params.append('userId', userId);
        return this.http.get(`${environment.apiUrl}/users/delete`, { params: params });
    }
}