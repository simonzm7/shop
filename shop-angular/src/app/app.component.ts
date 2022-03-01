import { Component } from '@angular/core';
import { MenuItem } from './core/model/MenuItem';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Shop';

  public routes: MenuItem[] = [
    {
      url: '/login',
      name: 'Sign In'
    },
    {
      url: '/signup',
      name: 'Sign Up'
    },
  ];

  public authRoutes: MenuItem[] = [
    {
      url: '/products',
      name: 'Products'
    }
  ];
}
