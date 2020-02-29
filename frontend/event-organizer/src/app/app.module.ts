import { FeaturesModule } from './features/features.module';
import { IntroComponent } from './intro/intro.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UserComponent } from './features/user/user.component';
import { MaterialModule } from './shared/material/material.module';
import {
  OktaAuthModule,
  OktaCallbackComponent,
  OktaAuthGuard,
} from '@okta/okta-angular';
import { AuthInterceptor } from './auth.interceptor';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { DatePipe } from '@angular/common';

const config = {
  issuer: 'https://dev-790783.okta.com/oauth2/default',
  redirectUri: 'http://localhost:4200/implicit/callback',
  clientId: '0oa2h4y94cjCObezP4x6',
  pkce: true
}


@NgModule({
  declarations: [
    AppComponent,
    IntroComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FeaturesModule,
    OktaAuthModule.initAuth(config),
    MatToolbarModule,
    HttpClientModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}, OktaAuthGuard, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
