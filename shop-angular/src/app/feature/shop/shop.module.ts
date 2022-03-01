import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopRoutingModule } from './shop-routing.module';
import { ProductsComponent } from './components/products/products.component';
import { IvyCarouselModule } from 'angular-responsive-carousel';
import { ProductCardComponent } from './components/product-card/product-card.component';
import { ListProductsComponent } from './components/list-products/list-products.component';
import { ProductService } from './shared/service/product.service';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  providers: [
    ProductService
  ],
  declarations: [
    ProductsComponent,
    ProductCardComponent,
    ListProductsComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    ShopRoutingModule,
    IvyCarouselModule
  ]
})
export class ShopModule { }
