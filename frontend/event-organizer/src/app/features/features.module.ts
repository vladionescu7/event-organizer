import { BrowserModule } from '@angular/platform-browser';
import { UserComponent } from './user/user.component';
import { NgModule } from '@angular/core';
import { MaterialModule } from '../shared/material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EventComponent } from './event/event.component';
import { OrganiserComponent } from './organiser/organiser.component';
import { AccessComponent } from './access/access.component';


@NgModule({
    declarations: [
        UserComponent,
        EventComponent,
        OrganiserComponent,
        AccessComponent,
        
    ],
    imports: [
        MaterialModule,
        FormsModule,
        ReactiveFormsModule,
        BrowserModule
    ],
    exports: [
        UserComponent
    ]
})
export class FeaturesModule { 

}