import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { ProductCategory } from 'src/app/shared/enums/ProductCategory';
import { Product } from '../../shared/model/Product';

import { ProductCardComponent } from './product-card.component';

describe('ProductCardComponent', () => {

  const product: Product = new Product(
    BigInt(10),
    'name product',
    'description',
    ProductCategory.ELECTRONICS,
    'http://localhost/img.png',
    10,
    50,
    new Date()
  );

  let component: ProductCardComponent;
  let fixture: ComponentFixture<ProductCardComponent>;


  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductCardComponent);
    component = fixture.componentInstance;

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render product', () => {
    component.cardTitle = product.productName;
    component.imageUrl = product.productImageUrl;

    expect(component.cardTitle).toEqual(product.productName);
    expect(component.imageUrl).toEqual(product.productImageUrl);
  });
});
