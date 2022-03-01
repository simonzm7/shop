import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SecurityGuard } from './core/guard/security.guard';
import { HomeComponent } from './feature/home/home.component';

const routes: Routes = [
  {
    path: '', 
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  { path: 'auth', loadChildren: () => import('./feature/auth/auth.module').then(m => m.AuthModule) },
  { path: 'profile', loadChildren: () => import('./feature/profile/profile.module').then(m => m.ProfileModule), canActivate: [SecurityGuard] },
  { path: 'products', loadChildren: () => import('./feature/shop/shop.module').then(m => m.ShopModule) },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
