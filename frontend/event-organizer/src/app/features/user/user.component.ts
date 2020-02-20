import { User } from '../../shared/model/user';
import { Component, OnInit } from '@angular/core';
import { IUser } from 'src/app/shared/model/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
user: IUser;

  constructor() { }

  ngOnInit() {
    this.user = new User();
  }

  saveUser() {
    console.log('Saving user ' + this.user);
    console.log(this.user);
  }

}
