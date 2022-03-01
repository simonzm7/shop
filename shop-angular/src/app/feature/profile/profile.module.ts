import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './profile.component';
import { ProfileRoutingModule } from './profile-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { ProfileService } from 'src/app/shared/services/profile.service';
import { FormsModule } from '@angular/forms';
import { IsLessThanValidatorDirective } from 'src/app/shared/directive/is-less-than-validator.directive';



@NgModule({
  providers: [ProfileService],
  declarations: [
    ProfileComponent,
    IsLessThanValidatorDirective
  ],
  imports: [
    CommonModule,
    ProfileRoutingModule,
    FormsModule,
    SharedModule
  ],
  
})
export class ProfileModule { }
