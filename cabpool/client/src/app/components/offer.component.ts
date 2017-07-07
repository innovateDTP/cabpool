import { Component } from '@angular/core';
import {RideModel} from "../domain/rideOffer";

@Component({  
  templateUrl: '../partials/offer.html',
  styleUrls: ['../app.component.css']
})
export class OfferComponent {
  rideModel :RideModel;
  public routes = [
    "Central" ,
    "Harbour" ,
    "Western"  
  ];

  constructor(){
    this.rideModel = new RideModel("", "", "", "", "","", "", "","","", "");
  }

  onSubmit(){
    alert(this.rideModel);
    console.log(this.rideModel);
  }
 
}
