import { HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { CONTENT_TYPE_JSON, HttpService } from "src/app/core/service/http.service";
import { ProductCategory } from "src/app/shared/enums/ProductCategory";
import { TokenService } from "src/app/shared/services/token.service";
import { environment } from "src/environments/environment";
import { Product } from "../model/Product";


@Injectable()
export class ProductService {

    constructor(
        private readonly httpService: HttpService,
        private readonly tokenService: TokenService
    ) {

    }

    getByCategory(category: ProductCategory): Observable<Product[]> {
        const httpParams: HttpParams = new HttpParams()
            .set('type', category.toString())
        const headers: HttpHeaders = new HttpHeaders(
            {
                'Content-Type': CONTENT_TYPE_JSON,
                'Authorization': `Bearer ${this.tokenService.getToken()}`
            });
        return this.httpService.doGetParameters(`${environment.endpoint}/product/category`, httpParams, {
            headers
        });
    }
}
