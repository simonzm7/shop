import { HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { CONTENT_TYPE_JSON, HttpService } from "src/app/core/service/http.service";
import { environment } from "src/environments/environment";
import { NewBalance } from "../model/newBalance";
import { User } from "../model/user";
import { TokenService } from "./token.service";


@Injectable()
export class ProfileService {

    private headers: HttpHeaders;

    constructor(
        private readonly httpService: HttpService,
        private readonly tokenService: TokenService,
    ) {
        this.headers = new HttpHeaders(
            {
                'Content-Type': CONTENT_TYPE_JSON,
                'Authorization': `Bearer ${this.tokenService.getToken()}`
            });
    }



    public getProfile(): Observable<User> {
        return this.httpService.doGet<User>(`${environment.endpoint}/users/me`, { headers: this.headers});
    }
    
    public putBalance(newBalance: NewBalance): Observable<void> {
        return this.httpService.doPost<NewBalance, void>(`${environment.endpoint}/balance`, newBalance, { headers: this.headers });
    }
}