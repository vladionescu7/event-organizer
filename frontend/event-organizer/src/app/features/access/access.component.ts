import { Component, OnInit, Input } from '@angular/core';
import { Access } from 'src/app/shared/model/access';

@Component({
  selector: 'app-access',
  templateUrl: './access.component.html',
  styleUrls: ['./access.component.css']
})
export class AccessComponent implements OnInit {
  @Input()
  access: Access;

  constructor() { }

  ngOnInit() {
  }

}
