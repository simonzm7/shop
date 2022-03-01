import { TestBed, inject } from '@angular/core/testing';
import { Router } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { TokenService } from 'src/app/shared/services/token.service';

import { SecurityGuard } from './security.guard';

describe('SecurityGuard', () => {
    let tokenService: TokenService;
    let router: Router;
    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [RouterTestingModule.withRoutes([])],
            providers: [SecurityGuard, TokenService]
        });
        tokenService = TestBed.inject(TokenService);
        router = TestBed.inject(Router);
        spyOn(router, 'navigate');
    });

    it('should create', inject([SecurityGuard], (guard: SecurityGuard) => {
        expect(guard).toBeTruthy();
    }));

    it('should return false is isAuth is false', inject([SecurityGuard], async (guard: SecurityGuard) => {
        spyOn(tokenService, 'isAuthenticated').and.returnValue(false);
        const result = await guard.canActivate();
        expect(result).toBeFalsy();
    }));
    
    it('should return false is isAuth is false', inject([SecurityGuard], async (guard: SecurityGuard) => {
        spyOn(tokenService, 'isAuthenticated').and.returnValue(true);
        const result = await guard.canActivate();
        expect(result).toBeTruthy();
    }));
});
