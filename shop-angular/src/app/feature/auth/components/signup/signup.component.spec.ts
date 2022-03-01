import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { HttpService } from 'src/app/core/service/http.service';
import { AuthService } from '../../share/service/auth.service';

import { SignupComponent } from './signup.component';

describe('SignupComponent', () => {
  let component: SignupComponent;
  let fixture: ComponentFixture<SignupComponent>;
  let authService: AuthService;
  let router: Router;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SignupComponent ],
      providers: [AuthService, HttpService],
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
    fixture = TestBed.createComponent(SignupComponent);
    component = fixture.componentInstance;

    authService = TestBed.inject(AuthService);
    router = TestBed.inject(Router);
    spyOn(authService, 'signUp').and.returnValue(
      of(BigInt(1))
    );
    spyOn(router, 'navigate');

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should create user', () => {
    component.onSubmit();
    expect(router.navigate).toHaveBeenCalledTimes(1);
  });
});
