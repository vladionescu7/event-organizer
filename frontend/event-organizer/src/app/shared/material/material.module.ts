import { NgModule } from '@angular/core';
import{MatInputModule} from '@angular/material/input';
import{MatCardModule, MatCard} from '@angular/material/card';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import { TextFieldModule } from '@angular/cdk/text-field';

@NgModule({
    imports:[
        MatInputModule,
        MatCardModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatSelectModule
    ],
    exports: [
        MatInputModule,
        MatCardModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatSelectModule
    ]
})
export class MaterialModule{

}