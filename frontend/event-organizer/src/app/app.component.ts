import { UserService } from './features/user/user.service';
import { Component } from '@angular/core';
import { OktaAuthService } from '@okta/okta-angular';
import { IUser, User } from './shared/model/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isAuthenticated: boolean;

  constructor(public oktaAuth: OktaAuthService,
              private userService: UserService) {
    // Subscribe to authentication state changes
    this.oktaAuth.$authenticationState.subscribe(
      (isAuthenticated: boolean) => {
        this.isAuthenticated = isAuthenticated;
        if (this.isAuthenticated) {
          this.oktaAuth.getUser().then(userInfo => {
            this.userService.getUserByOktaUserId(userInfo.sub)
              .subscribe(
                user => console.log(user),
                errorResponse => {
                  if (errorResponse.status === 404) {
                    const user: IUser = new User(
                      null,
                      userInfo.sub,
                      userInfo.firstName,
                      userInfo.lastName
                    );

                    this.userService.saveUser(user)
                      .subscribe(
                        _ => console.log('saved user successfully'),
                        _ => console.log('Failed to save user')
                      );
                  }
                }
              );
          });


        }
      }
    );
  }

  async ngOnInit() {
    // Get the authentication state for immediate use
    this.isAuthenticated = await this.oktaAuth.isAuthenticated();

  }

  login() {
    this.oktaAuth.loginRedirect('/');
  }

  logout() {
    this.oktaAuth.logout('/');
  }
}
