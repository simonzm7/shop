import { Injectable } from "@angular/core";
import { CookieService } from 'ngx-cookie-service';
import { BehaviorSubject } from "rxjs";

const TOKEN_NAME = 'token';

@Injectable()
export class TokenService {
    public isAuth: BehaviorSubject<boolean>;
    constructor(
        private readonly cookieService: CookieService
    ){
        this.isAuth = new BehaviorSubject<boolean>(this.checkToken());
    }

    public setToken(token: string): void {
        this.cookieService.set(TOKEN_NAME, token);
        this.isAuth.next(true);
    }

    public deleteToken(): void{
        this.cookieService.delete(TOKEN_NAME);
        this.isAuth.next(false);
    }

    public getToken(): string{
        return this.cookieService.get(TOKEN_NAME);
    }

    private checkToken(): boolean{
        return this.cookieService.check(TOKEN_NAME);
    }
    
    public isAuthenticated() {
        return this.isAuth.getValue();
    }

}