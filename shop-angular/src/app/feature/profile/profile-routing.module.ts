import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IsAuthGuard } from 'src/app/core/guard/is-auth.guard';
import { ProfileComponent } from './profile.component';




const routes: Routes = [
  { 
    path: '', 
    pathMatch: 'full',
    component: ProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingModule { }
