

import { Injectable } from "@angular/core";
import { CanActivate, Router, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { TokenService } from "src/app/shared/services/token.service";



@Injectable({
    providedIn: 'root'
})
export class IsAuthGuard implements CanActivate {

    constructor(
        private readonly tokenService: TokenService,
        private readonly router: Router
    ) {}

    canActivate(): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        this.tokenService.isAuth.subscribe(auth => {
            return auth;
        });
        return false;
    }

}