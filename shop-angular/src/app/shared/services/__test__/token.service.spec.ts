import { TestBed } from '@angular/core/testing';
import { CookieService } from 'ngx-cookie-service';
import { TokenService } from '../token.service';

describe('TokenService', () => {

    const TOKEN: string = 'token';

    let tokenService: TokenService;
    let cookieService: CookieService;

    beforeEach(async () => {

        const injector = TestBed.configureTestingModule({
            providers: [TokenService, CookieService]
        });
        injector.compileComponents();

        tokenService = TestBed.inject(TokenService);
        cookieService = TestBed.inject(CookieService);
        spyOn(cookieService, 'set');
        spyOn(cookieService, 'get');
        spyOn(cookieService, 'delete');
        spyOn(cookieService, 'check').and.returnValue(true);
    });

    it('should be create', () => {
        expect(tokenService).toBeTruthy();
    });

    it('should store token', () => {
        tokenService.setToken(TOKEN);
        tokenService.isAuth.subscribe(auth => {
            expect(auth).toBeTruthy();
        });
    });


    it('should delete token', () => {
        tokenService.deleteToken();
        tokenService.isAuth.subscribe(auth => {
            expect(auth).toBeFalse();
        });
        expect(cookieService.delete).toHaveBeenCalled();
    });
});
