import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ImageSliderComponent } from './image-slider/image-slider.component';
import { NgImageSliderModule } from 'ng-image-slider';
import { AccountCreationComponent } from './account/account-creation/account-creation.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AccountListComponent } from './account/account-list/account-list.component';
import { AdminScreenComponent } from './account/home/admin-screen/admin-screen.component';
import { UserScreenComponent } from './account/home/user-screen/user-screen.component';

@NgModule({
  declarations: [
    AppComponent,
    ImageSliderComponent,
    AccountCreationComponent,
    AccountListComponent,
    AdminScreenComponent,
    UserScreenComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgImageSliderModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
