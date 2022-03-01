import { HttpResponse } from '@angular/common/http';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { HttpService } from 'src/app/core/service/http.service';
import { environment } from 'src/environments/environment';
import { User } from '../../model/user';
import { ProfileService } from '../profile.service';
import { TokenService } from '../token.service';

describe('ProfileService', () => {
    const apiProfile = `${environment.endpoint}/users/me`;
    const apiBalance = `${environment.endpoint}/balance`;

    const user: User = {
        email: 'email@email.com',
        countryId: 1000000000,
        id: BigInt(10),
        name: 'name lastname',
        balance: {
          balance: 10.5,
          id: 1,
        },
      };


    let httpMock: HttpTestingController;
    let service: ProfileService;
    let tokenService: TokenService;

    beforeEach(async () => {
        const injector = TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [ProfileService, TokenService, HttpService]
        });

        httpMock = injector.inject(HttpTestingController);
        service = TestBed.inject(ProfileService);

        tokenService = TestBed.inject(TokenService);
        spyOn(tokenService, 'getToken').and.returnValue('token');

    });

    it('should be create', () => {
        expect(service).toBeTruthy();
    });

    it('should fetch profile', () => {
        service.getProfile().subscribe(data => {
            expect(data).toEqual(user);
        });

        const req = httpMock.expectOne(apiProfile);
        expect(req.request.method).toBe('GET');
        req.event(new HttpResponse<User>({body: user}));
    });

    it('should put new balance', () => {
        service.putBalance({
            id: 1,
            newBalance: 5.5
        }).subscribe((d) => {
            expect(d).toBe(null as any);
        });

        const req = httpMock.expectOne(apiBalance);
        expect(req.request.method).toBe('POST');
        req.event(new HttpResponse<void>({}));
    });
});
