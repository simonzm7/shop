import {  NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';
import { SigninComponent } from './components/signin/signin.component';
import { FormsModule } from '@angular/forms';
import { AuthService } from './share/service/auth.service';
import { SharedModule } from 'src/app/shared/shared.module';
import { TokenService } from 'src/app/shared/services/token.service';
import { SignupComponent } from './components/signup/signup.component';


@NgModule({
  declarations: [
    SigninComponent,
    SignupComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    AuthRoutingModule,
    SharedModule
  ],
  providers: [
    AuthService,
    TokenService
  ],

})
export class AuthModule { }
