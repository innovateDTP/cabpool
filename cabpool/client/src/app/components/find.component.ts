import { Component } from '@angular/core';
import {UtilService} from "../services/util.service";
import {RideModel} from "../domain/rideOffer";
import {Search} from "../domain/search";
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import 'assets/scripts/util.js'
declare var webGlObject: any;
var $ : any;

@Component({  
  templateUrl: '../partials/find.html',
  styleUrls: ['../app.component.css']
})
export class FindComponent {
helloFromService : string;
searchModel : Search;
rideModel : RideModel;
providerList :any[];

public routes = [
    "Central" ,
    "Harbour" ,
    "Western"  
];


constructor(private utilService : UtilService, private http: Http) { 
  this.searchModel = new Search( "", "", "","");
}


  getHelloFromService() : void {
    this.helloFromService =  this.utilService.getString();
  }

  searchForMatch(){
    
    console.log(this.searchModel);
    this.getProviderList();
  }

  getProviderList() : void {
     this.utilService.getProviderList(this.searchModel.route, this.searchModel.date)
        .subscribe((data : any) => {      
    this.providerList = data;    

    for (var i = 0; i < this.providerList.length; i++) {
      let from =  this.providerList[i].from; 
      let to = this.providerList[i].to;
     // var retVal1 = webGlObject.getLanLtd(from);
       //var retVal2 = webGlObject.getLanLtd(to);
      var map1 = {};
      var map2 = {}; 
      var map3 = {}; 
      
      var urlFrom = "https://maps.googleapis.com/maps/api/geocode/json?address=" + from + "&key=AIzaSyCtih2BpQD5Y3oEsQokyEzyuiuG7u_JfxE";        
      var urlTo = "https://maps.googleapis.com/maps/api/geocode/json?address=" + to + "&key=AIzaSyCtih2BpQD5Y3oEsQokyEzyuiuG7u_JfxE";     
      var urlDest = "https://maps.googleapis.com/maps/api/geocode/json?address=" + this.searchModel.to + "&key=AIzaSyCtih2BpQD5Y3oEsQokyEzyuiuG7u_JfxE";  

      this.http
          .get(urlFrom)
          .map(res => {res.json();             
            return res.json();
          })
        .subscribe(data => {              
          var longLat = data;
          var obj = data;
          var a = obj["results"][0];
          var lat = a["geometry"]["location"]["lat"];
          var lng = a["geometry"]["location"]["lng"];
          
          map1["lat"] = lat;
          map1["lng"] = lng;
         // console.log(map1);        
     });   

     this.http
          .get(urlTo)
          .map(res => {res.json();             
            return res.json();
          })
        .subscribe(data => {       
          var longLat = data;           
          var obj = data;
          var a = obj["results"][0];
          var lat = a["geometry"]["location"]["lat"];
          var lng = a["geometry"]["location"]["lng"];          
          map2["lat"] = lat;
          map2["lng"] = lng;
          //console.log(map2);        
  });  


  this.http
          .get(urlDest)
          .map(res => {res.json();             
            return res.json();
          })
        .subscribe(data => {       
          var longLat = data;           
          var obj = data;
          var a = obj["results"][0];
          var lat = a["geometry"]["location"]["lat"];
          var lng = a["geometry"]["location"]["lng"];          
          map3["lat"] = lat;
          map3["lng"] = lng;
         // console.log(map3);

          webGlObject.isOnRoute(map1["lat"], map1["lng"], map2["lat"], map2["lng"], map3["lat"], map3["lng"]);
          this.searchModel = new Search( "", "", "","");

  });                    

   }

    this.searchModel.route = "";
     this.searchModel.date ="";
      
      
    });
  }  
 
}
