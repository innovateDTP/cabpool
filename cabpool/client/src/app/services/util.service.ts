import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {environment} from '../../environments/environment';
import {RideModel} from "../domain/rideOffer";


@Injectable()
export class UtilService {
    modelArray:Array<RideModel> = [];
    serverUrl : string = "/api/findByRoute/";
    postOfferURL : string = "/api/offerRide";


  constructor(private http: Http) { }

  getString() : string {
      return "hello world from the service";
  }

  getProviderList(route:String, date:String) : Observable<any> {       
      
      
      this.serverUrl = this.serverUrl +  route + "/" + date; 
      console.log("In service URL: "  +this.serverUrl);
      return this.http
          .get(this.serverUrl)
          .map((response: Response) => {
              console.log("REST response json: " + (JSON.stringify(response.json())));
              this.serverUrl = "/api/findByRoute/";           

              this.modelArray = response.json() || {};
              
              return this.modelArray;
          });
  }

postValues(){
    this.http
          .get(this.serverUrl)
    .map(res => <RideModel[]>res.json())
  .subscribe(data => {
    // data corresponds to a list of OrderBasket
  });
   
}
   

}
