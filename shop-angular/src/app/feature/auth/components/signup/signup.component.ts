import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { SignUp } from '../../share/model/signup';
import { AuthService } from '../../share/service/auth.service';
import { INPUT_PATTERN } from '../../share/util/input-pattern';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
  title = 'SignUp on Shop';
  signupInput: SignUp = {
    name: '',
    email: '',
    countryId: null,
    password: ''
  };
  patterns =  {
    email: INPUT_PATTERN.email,
    name: INPUT_PATTERN.name,
    nationalIdentity: INPUT_PATTERN.numeric
  }

  constructor(
    private readonly setTitle: Title,
    private readonly authService: AuthService,
    private readonly router: Router
  ) {
    this.setTitle.setTitle(this.title);
   }


  private onSignUp(){
    this.router.navigate(['/login']);
  }
  onSubmit() {
    this.authService.signUp(this.signupInput)
    .subscribe({
      next: this.onSignUp.bind(this)
    })
  }
}
