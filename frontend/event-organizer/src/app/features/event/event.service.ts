import { IUser } from './../../shared/model/user';
import { mergeMap } from 'rxjs/operators';
import { UserService } from './../user/user.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IEvent } from 'src/app/shared/model/event';
import { Observable } from 'rxjs';
import { apiUrl } from 'src/environments/environment';
import { DatePipe } from '@angular/common';

@Injectable({
    providedIn: 'root'
})

export class EventService {
    private static EVENTS_API = '/api/events';
    date: Date;
    constructor(
        private httpClient: HttpClient,
        private userService: UserService,
        public datePipe: DatePipe

    ) { }
    saveEvent(event: IEvent): Observable<IEvent> {
        return this.userService.getCurrentOktaAuthUser()
            .pipe(
                mergeMap(iUser => {
                    console.log('organiser: ');
                    console.log(iUser);
                    event.organiser = iUser;
                    event.organiserId = iUser.id;
                    return this.httpClient.post<IEvent>(`${apiUrl}${EventService.EVENTS_API}`, event);
                })
            );
    }

    toDateString(eventDate: Date) {
        const latestDate = this.datePipe.transform(eventDate, 'dd-MM-yyyy');

        return latestDate;
    }

}
