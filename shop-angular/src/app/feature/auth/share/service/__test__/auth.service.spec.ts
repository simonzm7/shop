import { HttpResponse } from '@angular/common/http';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

import { HttpService } from 'src/app/core/service/http.service';
import { environment } from 'src/environments/environment';
import { SignIn } from '../../model/signin';
import { SignInResponse } from '../../model/signin-response';
import { SignUp } from '../../model/signup';
import { AuthService } from '../auth.service';


describe('AuthService', () => {

    const apiLogin = `${environment.endpoint}/login`;
    const apiSignUp = `${environment.endpoint}/users`;

    let httpMock: HttpTestingController;
    let service: AuthService;

    beforeEach(async () => {
        const injector = TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [AuthService, HttpService]
        });
        httpMock = injector.inject(HttpTestingController);
        service = TestBed.inject(AuthService);

    });

    it('should be create', () => {
        expect(service).toBeTruthy();
    });

    it('should signin user', () => {
        const dummySignInResponse: SignInResponse = new SignInResponse('token');
        const dummyUser: SignIn = {
            email: 'email@email.com',
            password: '123456'
        };
        service.signIn(dummyUser).subscribe(data => {
            expect(data).toEqual(dummySignInResponse);
        });

        const req = httpMock.expectOne(apiLogin);
        expect(req.request.method).toBe('POST');
        req.event(new HttpResponse<SignInResponse>({body: dummySignInResponse}));
    });

    it('should signup user', () => {
        const dummySignUnResponse: BigInt = BigInt(15);
        const dummyUser: SignUp = {
            email: 'email@email.com',
            password: '123456',
            countryId: 1,
            name: 'name'
        };
        service.signUp(dummyUser).subscribe(data => {
            expect(data).toEqual(dummySignUnResponse);
        });


        const req = httpMock.expectOne(apiSignUp);
        expect(req.request.method).toEqual('POST');
        req.event(new HttpResponse<BigInt>({body: dummySignUnResponse}));
     
    });
});
