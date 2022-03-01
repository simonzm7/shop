import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductCategory } from 'src/app/shared/enums/ProductCategory';


interface CategoryCard {
  imgUrl: string;
  title: ProductCategory;
}
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent {

  productCategory: CategoryCard[] = [
    {
      imgUrl: 'https://images.unsplash.com/photo-1496171367470-9ed9a91ea931?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2670&q=80',
      title: ProductCategory.ELECTRONICS
    },
    {
      imgUrl: 'https://www.kindpng.com/picc/m/224-2247022_grand-theft-auto-v-gta-v-hd-ps4.png',
      title: ProductCategory.GAMES
    },
    {
      imgUrl: 'https://images.unsplash.com/photo-1483985988355-763728e1935b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2670&q=80',
      title: ProductCategory.FASHION
    },
  ];


  constructor(private readonly router: Router) {

  }

  searchCategory(category: string){
    this.router.navigate(['/products/category'], {queryParams: {
      type: category
    }});
  }

}
