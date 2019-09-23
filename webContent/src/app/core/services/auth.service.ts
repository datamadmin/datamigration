import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import { CookieService } from '../services/cookie.service';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    user: any;

    constructor(private http: HttpClient, private cookieService: CookieService) {
        this.initCurrentUser();
    }

    initCurrentUser() {
        if (this.cookieService.getCookie('currentUser')) {
            this.user = JSON.parse(this.cookieService.getCookie('currentUser'));
        }
    }

    /**
     * Returns the current user
     */
    public currentUser(): any {
        return this.user;
    }

    setUser(user: any) {
        this.user = user;
        this.cookieService.setCookie('currentUser', JSON.stringify(user), 15);
    }

    /**
     * Performs the auth
     * @param userName userName of user
     * @param password password of user
     */
    login(userName: string, password: string) {
        const params = {
            "userName": userName,
            "password": password
        }
        return this.http.get(`${environment.apiUrl}/users/login`, { params });
    }

    /**
     * Logout the user
     */
    logout() {
        // remove user from local storage to log user out
        this.cookieService.deleteCookie('currentUser');
        this.user = null;
    }
}

