import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TokenService } from './services/token.service';
import { CookieService } from 'ngx-cookie-service';
import { ProfileService } from './services/profile.service';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [
    TokenService,
    CookieService,
    ProfileService
  ],
  exports: [
    HttpClientModule,
  ]
})
export class SharedModule { }
