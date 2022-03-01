import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpService } from 'src/app/core/service/http.service';
import { User } from 'src/app/shared/model/user';
import { ProfileService } from 'src/app/shared/services/profile.service';
import { TokenService } from 'src/app/shared/services/token.service';

import { ProfileComponent } from './profile.component';

describe('ProfileComponent', () => {
  let component: ProfileComponent;
  let fixture: ComponentFixture<ProfileComponent>;
  let profileService: ProfileService;
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
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileComponent ],
      providers: [ProfileService, HttpService, TokenService],
      imports: [HttpClientModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileComponent);
    component = fixture.componentInstance;
    profileService = TestBed.inject(ProfileService);
    spyOn(profileService, 'getProfile').and.returnValue(
      of(user)
    );

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    expect(component.user).not.toBeNull();
    expect(component.user?.email).toEqual(user.email);
    expect(component.user?.name).toEqual(user.name);
    expect(component.user?.balance).toEqual(user.balance);
    expect(component.user?.id).toEqual(user.id);
    expect(component.totalBalance).toEqual(user.balance.balance);
  });

  it('should toggle modal', () => {
    component.toggleModal();
    expect(component.modalOpen).toBeTrue();
  });

});
