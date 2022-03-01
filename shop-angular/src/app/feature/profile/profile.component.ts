import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { User } from 'src/app/shared/model/user';
import { ProfileService } from 'src/app/shared/services/profile.service';
import { INPUT_PATTERN } from '../auth/share/util/input-pattern';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  public title: string = 'Profile';

  constructor(
    private readonly profileService: ProfileService,
    private readonly titleService: Title
    ) {
      this.titleService.setTitle(this.title);
    }

  public user: User | null = null;
  public totalBalance: number = 0;

  public plusPath: string = '../../../assets/static/plus.png';
  public closePath: string = '../../../assets/static/close.png';

  public isNumberPattern: string = INPUT_PATTERN.numericWithDecimal;
  public newBalance: number = 0;

  public modalOpen: boolean = false;

  ngOnInit(): void {
    this.profileService.getProfile()
    .subscribe(u => {
      this.user = u;
      this.totalBalance = u.balance.balance;
    });
  }

  onSubmit() {
    this.profileService.putBalance({
      id: this.user?.balance.id,
      newBalance: this.newBalance
    }).subscribe(() => {
      if (this.user){
        this.user.balance.balance = Number(this.user.balance.balance) + Number(this.newBalance);
      }
      this.toggleModal();
    })
  }
  toggleModal = () => this.modalOpen = !this.modalOpen;
}
