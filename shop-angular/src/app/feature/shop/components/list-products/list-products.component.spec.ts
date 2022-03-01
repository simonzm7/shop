import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { CookieService } from 'ngx-cookie-service';
import { of } from 'rxjs';
import { HttpService } from 'src/app/core/service/http.service';
import { ProductCategory } from 'src/app/shared/enums/ProductCategory';
import { TokenService } from 'src/app/shared/services/token.service';
import { Product } from '../../shared/model/Product';
import { ProductService } from '../../shared/service/product.service';

import { ListProductsComponent } from './list-products.component';

describe('ListProductsComponent', () => {


  let component: ListProductsComponent;
  let fixture: ComponentFixture<ListProductsComponent>;
  let productService: ProductService;
  const productsList: Product[] = [new Product(
    BigInt(10),
    'name product',
    'description',
    ProductCategory.ELECTRONICS,
    '',
    10,
    50,
    new Date()
  )];
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListProductsComponent ],
      imports: [RouterTestingModule, HttpClientModule],
      providers: [ProductService, TokenService, CookieService, HttpService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListProductsComponent);
    component = fixture.componentInstance;

    productService = TestBed.inject(ProductService);
    spyOn(productService, 'getByCategory').and.returnValue(
      of(productsList)
      );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    expect(component.products.length).toEqual(1);
  });
});
