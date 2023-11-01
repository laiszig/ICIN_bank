import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ImageSliderComponent } from './image-slider/image-slider.component';
import { NgImageSliderModule } from 'ng-image-slider';
import { AccountCreationComponent } from './account/account-creation/account-creation.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AccountListComponent } from './account/account-list/account-list.component';
import { AdminScreenComponent } from './home/admin-screen/admin-screen.component';
import { UserScreenComponent } from './home/user-screen/user-screen.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SecurityInterceptorService } from './security-interceptor.service';
import { AccountDetailsComponent } from './account/account-details/account-details.component';
import { ClientComponent } from './client/client.component';
import { CheckbookComponent } from './checkbook/checkbook.component';
import { MoveFundsComponent } from './account/move-funds/move-funds.component';

@NgModule({
  declarations: [
    AppComponent,
    ImageSliderComponent,
    AccountCreationComponent,
    AccountListComponent,
    AdminScreenComponent,
    UserScreenComponent,
    LoginComponent,
    RegisterComponent,
    AccountDetailsComponent,
    ClientComponent,
    CheckbookComponent,
    MoveFundsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgImageSliderModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: SecurityInterceptorService, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
