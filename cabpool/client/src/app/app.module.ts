import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule }   from '@angular/router';

import { AppComponent } from './app.component';
import { FindComponent } from './components/find.component';
import { OfferComponent } from './components/offer.component';
import { ContactComponent } from './components/contact.component';
import {AppRoutes} from './app.routes';
import { UtilService } from './services/util.service';

@NgModule({
  declarations: [
    AppComponent,
    FindComponent,
    OfferComponent,
    ContactComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    RouterModule.forRoot(AppRoutes),
    HttpModule
  ],
  providers: [UtilService],
  bootstrap: [AppComponent]
})
export class AppModule { }
