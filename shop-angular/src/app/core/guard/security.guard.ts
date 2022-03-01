import { Injectable } from "@angular/core";
import { CanActivate, Router, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { TokenService } from "src/app/shared/services/token.service";



@Injectable({
    providedIn: 'root'
})
export class SecurityGuard implements CanActivate {

    constructor(
        private readonly tokenService: TokenService,
        private readonly router: Router
        ){}

    canActivate(): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        if(this.tokenService.isAuthenticated()){
            return true;
        }
        this.router.navigate(['/login']);
        return false;
    }

}