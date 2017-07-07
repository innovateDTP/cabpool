// Imports
// Deprecated import
// import { provideRouter, RouterConfig } from '@angular/router';
import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FindComponent } from './components/find.component';
import { OfferComponent } from './components/offer.component';
import { ContactComponent } from './components/contact.component';



// Route Configuration
export const AppRoutes: Routes = [    
  { path: '', component: FindComponent},                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
  { path: 'find', component: FindComponent },
  { path: 'offer', component: OfferComponent },
  { path: 'contact', component: ContactComponent }
];