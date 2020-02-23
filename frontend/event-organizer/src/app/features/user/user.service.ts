import { OktaAuthService } from '@okta/okta-angular';
import {IUser, User} from '../../shared/model/user';
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, from } from 'rxjs';
import { apiUrl } from 'src/environments/environment';
import { mergeMap } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class UserService {
    private static USERS_API = "/api/users";
    constructor(private httpClient: HttpClient,
        private oktaAuthService: OktaAuthService ) {

    }

saveUser(user: IUser): Observable<IUser> {
    return this.httpClient.post<IUser>(`${apiUrl}${UserService.USERS_API}`, user);

}

getUserByOktaUserId(oktaUserId: string): Observable<IUser> {
 return this.httpClient.get<IUser>(`${apiUrl}${UserService.USERS_API}/${oktaUserId}`);
  }
}