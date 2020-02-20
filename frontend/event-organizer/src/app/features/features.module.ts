import { UserComponent } from './user/user.component';
import { NgModule } from '@angular/core';
import { MaterialModule } from '../shared/material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
    declarations: [
        UserComponent
    ],
    imports: [
        MaterialModule,
        FormsModule,
        ReactiveFormsModule
    ],
    exports: [
        UserComponent
    ]
})
export class FeaturesModule { 

}