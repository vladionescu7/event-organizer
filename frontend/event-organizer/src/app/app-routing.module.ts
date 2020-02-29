import { UserComponent } from './features/user/user.component';
import { EventComponent } from './features/event/event.component';
import { IntroComponent } from './intro/intro.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OktaCallbackComponent, OktaAuthGuard } from '@okta/okta-angular';


const routes: Routes = [
  {
    path: 'intro',
    component: IntroComponent
  },
  {
    path: 'user',
    component: UserComponent
  }
,
  {
    path: 'new-event',
    component: EventComponent, 
    canActivate: [OktaAuthGuard]
  },
  {
    path: 'implicit/callback',
    component: OktaCallbackComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }
