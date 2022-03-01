import { Component, Input, OnInit } from '@angular/core';
import { ProductCategory } from 'src/app/shared/enums/ProductCategory';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.scss']
})
export class ProductCardComponent implements OnInit {

  @Input()
  public imageUrl: string = '';
  @Input() cardTitle: ProductCategory | string = '';
  @Input() cardPrice: string = '';

  constructor() { }

  ngOnInit(): void {
  }

}
