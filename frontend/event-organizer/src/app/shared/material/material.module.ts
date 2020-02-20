import { NgModule } from '@angular/core';
import{MatInputModule} from '@angular/material/input';
import{MatCardModule, MatCard} from '@angular/material/card';

@NgModule({
    imports:[
        MatInputModule,
        MatCardModule
    ],
    exports: [
        MatInputModule,
        MatCardModule
    ]
})
export class MaterialModule{

}