import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IEvent } from 'src/app/shared/model/event';
import { Observable } from 'rxjs';
import { apiUrl } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})

export class EventService {
    private static EVENTS_API = '/api/events';
    constructor(
        private httpClient: HttpClient
    ) {}
    saveEvent(event: IEvent): Observable<IEvent> {
        return this.httpClient.post<IEvent>(`${apiUrl}${EventService.EVENTS_API}`, event);
    }

}
