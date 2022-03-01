import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest, HttpEvent } from '@angular/common/http';
import { EMPTY, Observable, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { TokenService } from 'src/app/shared/services/token.service';

const UNAUTHORIZED = 401;
const FORBIDDEN = 403;

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(
    private readonly router: Router,
    private readonly tokenService: TokenService
    ) { }

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {

    return next.handle(req).pipe(
      catchError((error) => {
        switch (error.status) {
        
          case UNAUTHORIZED:
            this.router.navigate(['/login']);
            this.tokenService.deleteToken();
            return throwError(() => EMPTY);
          case FORBIDDEN:
            this.router.navigate(['/home']);
            this.tokenService.deleteToken();
            return throwError(() => EMPTY);
          default:
            return throwError(() => error);
        }
      })
    );
  }
}
