import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/shared/services/token.service';
import { SignIn } from '../../share/model/signin';
import { AuthService } from '../../share/service/auth.service';
import { INPUT_PATTERN } from '../../share/util/input-pattern';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent  {
  title = 'Sign in to Shop';
  loginInput: SignIn = {
    email: '',
    password: ''
  };

  patterns = {
    email: INPUT_PATTERN.email, 
  }


  public constructor(
    private readonly titleService: Title,
    private readonly authService: AuthService,
    private readonly tokenService: TokenService,
    private readonly router: Router
  ){
    this.titleService.setTitle(this.title);
  }

  onSubmit(): void {
    this.authService.signIn(this.loginInput)
    .subscribe(data => {
      this.tokenService.setToken(data.token)
      this.router.navigate(['home']);
    });
  }
}
