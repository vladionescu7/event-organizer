import { OktaAuthService } from '@okta/okta-angular';
import {IUser} from '../../shared/model/user';
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { apiUrl } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class UserService {
    private static USERS_API = "/api/users";
    constructor(private httpClient: HttpClient,
        private OktaAuthService: OktaAuthService ) {

    }

saveUser(user: IUser): Observable<IUser> {
    return this.httpClient.post<IUser>(`${apiUrl}/${UserService.USERS_API}`, user)

}

getUserByOktaUserId(oktaUserId: string): Observable<IUser>{
    const accessToken = this.OktaAuthService.getAccessToken().then(accessToken => )
    const headers = new HttpHeaders( {
        Authorization: 'Bearer ' + accessToken
    });
}

}