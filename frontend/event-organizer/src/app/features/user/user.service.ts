import {IUser} from '../../shared/model/user';
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class UserService {
    
    constructor(private httpClient: HttpClient){

    }

saveUser(user: IUser){

}

}