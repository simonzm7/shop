import { HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { CONTENT_TYPE_ENCODED, HttpService } from "src/app/core/service/http.service";
import { environment } from "src/environments/environment";
import { SignIn } from "../model/signin";
import { SignInResponse } from "../model/signin-response";
import { SignUp } from "../model/signup";


@Injectable()
export class AuthService {

    constructor(
        protected httpService: HttpService
    ){}

    public signIn(credentials: SignIn){
        const paramsBody: URLSearchParams = new URLSearchParams();
        paramsBody.set('email', credentials.email);
        paramsBody.set('password', credentials.password);

       return this.httpService.doPost<URLSearchParams, SignInResponse>(`${environment.endpoint}/login`, paramsBody, {
            headers: new HttpHeaders({'Content-Type': CONTENT_TYPE_ENCODED})
        });
    }
    public signUp(credentials: SignUp) {
       return this.httpService.doPost<SignUp, BigInt>(`${environment.endpoint}/users`, credentials);
    }
}