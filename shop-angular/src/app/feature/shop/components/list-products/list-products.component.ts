import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../../shared/model/Product';
import { ProductService } from '../../shared/service/product.service';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.scss']
})
export class ListProductsComponent implements OnInit {

  public products: Product[] = [];

  constructor(
    private readonly activatedRoute: ActivatedRoute,
    private readonly productService: ProductService
    ) { }

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(params => {
      this.productService.getByCategory(params['type'])
      .subscribe((resp: Product[])=> this.products = [...resp]);
    });
  }

}
