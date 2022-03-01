import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/shared/services/token.service';
import { MenuItem } from '../../model/MenuItem';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  @Input() public items: MenuItem[] = [];
  @Input() public authItems: MenuItem[] = [];
  public isAuthenticated: boolean = false;

  profileUrl: string = '../../../../assets/static/profile-user.png';
  public popupActive: boolean =  false;
  constructor(
    private readonly tokenService: TokenService,
    private readonly router: Router
    ) {

    }

  ngOnInit(): void {
    this.tokenService.isAuth.subscribe(isAuth => {
      this.isAuthenticated = isAuth;
    });
  }

  togglePopup() {
    this.popupActive = !this.popupActive;
  }

  onSignOut(){
    this.tokenService.deleteToken();
    this.router.navigate(['/login']);
    this.popupActive = false;
  }

}
