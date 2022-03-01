import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthModule } from './feature/auth/auth.module';
import { HomeComponent } from './feature/home/home.component';
import { CoreModule } from './core/core.module';
import { ProfileModule } from './feature/profile/profile.module';
import { NavbarComponent } from './core/components/navbar/navbar.component';
import { ShopModule } from './feature/shop/shop.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AuthModule,
    ProfileModule,
    CoreModule,
    ShopModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
