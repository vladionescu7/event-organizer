import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/shared/model/user';

@Component({
  selector: 'app-organiser',
  templateUrl: './organiser.component.html',
  styleUrls: ['./organiser.component.css']
})
export class OrganiserComponent implements OnInit {

  @Input()
  organiser: User;

  constructor() { }

  ngOnInit() {
  }

}
