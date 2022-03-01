import { HttpParams, HttpResponse } from '@angular/common/http';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpService } from 'src/app/core/service/http.service';
import { ProductCategory } from 'src/app/shared/enums/ProductCategory';
import { TokenService } from 'src/app/shared/services/token.service';
import { environment } from 'src/environments/environment';
import { Product } from '../model/Product';
import { ProductService } from './product.service';

describe('ProfileService', () => {

    const apiProducts = `${environment.endpoint}/product/category?type=${ProductCategory.ELECTRONICS}`;

    const productsList: Product[] = [new Product(
        BigInt(10),
        'name product',
        'description',
        ProductCategory.ELECTRONICS,
        'http://localhost/img.png',
        10,
        50,
        new Date()
    )];

    let httpMock: HttpTestingController;
    let service: ProductService;

    beforeEach(async () => {
        const injector = TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [ProductService, TokenService, HttpService]
        });

        httpMock = injector.inject(HttpTestingController);
        service = TestBed.inject(ProductService);

    });

    it('should be create', () => {
        expect(service).toBeTruthy();
    });

    it('should fetch products', () => {
        service.getByCategory(ProductCategory.ELECTRONICS).subscribe(data => {
            expect(data).toEqual(productsList);
        });

        const req = httpMock.expectOne(apiProducts);
        expect(req.request.method).toBe('GET');
        req.event(new HttpResponse<Product[]>({body: productsList}));
    });
});
