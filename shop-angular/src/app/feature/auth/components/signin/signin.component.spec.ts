import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { CookieService } from 'ngx-cookie-service';
import { HttpService } from 'src/app/core/service/http.service';
import { TokenService } from 'src/app/shared/services/token.service';
import { AuthService } from '../../share/service/auth.service';

import { SigninComponent } from './signin.component';

import { of } from 'rxjs';
import { SignInResponse } from '../../share/model/signin-response';
import { Router } from '@angular/router';
import { ElementRef } from '@angular/core';

describe('SigninComponent', () => {
  let component: SigninComponent;
  let fixture: ComponentFixture<SigninComponent>;
  let authService: AuthService;
  let router: Router;
  const signInResponse: SignInResponse = new SignInResponse('token');

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SigninComponent ],
      providers: [AuthService, TokenService,HttpService, CookieService],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule,
        FormsModule,
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SigninComponent);
    component = fixture.componentInstance;
    authService = TestBed.inject(AuthService);
    router = TestBed.inject(Router);
    spyOn(authService, 'signIn').and.returnValue(
      of(signInResponse)
    );
    spyOn(router, 'navigate');

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should signin user', () => {
    const hostElement: HTMLElement = fixture.debugElement.nativeElement;
    const submitInput: HTMLInputElement = hostElement.querySelector(".submitBtn")!;
    submitInput.click();
    
    expect(authService.signIn).toHaveBeenCalledTimes(1);
    expect(router.navigate).toHaveBeenCalledTimes(1);
  });
});
