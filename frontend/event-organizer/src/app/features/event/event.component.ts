
import { Component, OnInit } from '@angular/core';
import { IEvent, Event } from 'src/app/shared/model/event';
import { Access } from 'src/app/shared/model/access';
import { EventService } from './event.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from 'src/environments/environment';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {
  private static EVENTS_API = '/api/events';
  event: IEvent;
  accessOptions = [
    Access.PUBLIC, Access.PRIVATE
  ];

  constructor(private eventService: EventService, private httpClient: HttpClient
  ) { }

  ngOnInit() {
    this.event = new Event();
  }

  saveEvent(event: IEvent) {
    console.log(event);
    return this.httpClient.post<IEvent>(`${apiUrl}${EventComponent.EVENTS_API}`, event)
      .subscribe(
        data => {
          this.event = data;
        });

  }

}
