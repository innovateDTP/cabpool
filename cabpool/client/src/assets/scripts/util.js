var sourceLat, sourceLng;
		var destinationLat, destinationLng;
		function initialize() {

			var directionsDisplay = new google.maps.DirectionsRenderer();
			var directionsService = new google.maps.DirectionsService();
			var map;
			var routeBoxer = new RouteBoxer();
			var distance = 1;
			var cascadiaFault;
			var routeBounds = [];

			var mapOptions = {
				center: new google.maps.LatLng(37.7831,-122.4039),
				zoom: 12,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			};

			var map = new google.maps.Map(document.getElementById('map'), mapOptions);

			directionsDisplay.setMap(map);

			var source = new google.maps.places.Autocomplete(document.getElementById('source'));
			var infoWindow = new google.maps.InfoWindow();
			var marker = new google.maps.Marker({
			  map: map
			});

			google.maps.event.addListener(source, 'place_changed', function() {
			  infoWindow.close();
			  var place = source.getPlace();
			  marker.setPosition(place.geometry.location);
			  sourceLat = marker.getPosition().lat();
			  sourceLng = marker.getPosition().lng();
			  infoWindow.setContent('<div><strong>' + place.name + '</strong><br>');
			});

			var destination = new google.maps.places.Autocomplete(document.getElementById('destination'));
			var infoWindow = new google.maps.InfoWindow();
			var marker = new google.maps.Marker({
			  map: map
			});

			google.maps.event.addListener(destination, 'place_changed', function() {
			  infoWindow.close();
			  var place = destination.getPlace();
			  marker.setPosition(place.geometry.location);
			  destinationLat = marker.getPosition().lat();
			  destinationLng = marker.getPosition().lng();
			  infoWindow.setContent('<div><strong>' + place.name + '</strong><br>');

				//Same event, draw route
			    var start = new google.maps.LatLng(sourceLat, sourceLng);
				var end = new google.maps.LatLng(destinationLat, destinationLng);
				var request = {
					origin: start,
					destination: end,
					travelMode: google.maps.TravelMode.DRIVING
				};
				directionsService.route(request, function(response, status) {
					if (status == google.maps.DirectionsStatus.OK) {
						directionsDisplay.setDirections(response);
						directionsDisplay.setMap(map);
						
						// Box around the overview path of the first route
					    var path = response.routes[0].overview_path;
					    var boxes = routeBoxer.box(path, distance);
						var pathsTemp = [];
						for (var i = 0; i < boxes.length; i++) {
							var bounds = boxes[i];
							// Perform search over this bounds
							pathsTemp.push(bounds.getCenter());
							routeBounds.push(bounds);
						}
						var temp = {}
						cascadiaFault = new google.maps.Polyline({
							path: pathsTemp
						 });
						 
						//alert(pathsTemp);
						//alert(cascadiaFault.getPath());
					} else {
						alert("Directions Request from " + start.toUrlValue(6) + " to " + end.toUrlValue(6) + " failed: " + status);
					}
				});
			});

			var customerSource = new google.maps.places.Autocomplete(document.getElementById('customerSource'));
			var infoWindow = new google.maps.InfoWindow();
			var marker = new google.maps.Marker({
			  map: map
			});

			google.maps.event.addListener(customerSource, 'place_changed', function() {
			  infoWindow.close();
			  var place = customerSource.getPlace();
			  marker.setPosition(place.geometry.location);
			  sourceLat = marker.getPosition().lat();
			  sourceLng = marker.getPosition().lng();
			  infoWindow.setContent('<div><strong>' + place.name + '</strong><br>');
			});
			
			google.maps.event.addDomListener(document.getElementById('search'), 'click', function searchLocation() {
			  alert(cascadiaFault);
			  if(google.maps.geometry.poly.isLocationOnEdge(customerSource.getPlace().geometry.location, cascadiaFault, 0.01)) {
				alert("On the way..!!");
			  } else {
				alert("Not on the way..!!");
			  }
			 // Console.log(routeBounds);
			 console.log("cascadiaFault : " + JSON.stringify(cascadiaFault));
			  console.log("--------" + customerSource.getPlace().geometry.location);
			});

		}
		
		google.maps.event.addDomListener(window, "load", initialize);


        function initialize1() {
        //cutomer destination
    var myPosition = new google.maps.LatLng(19.129281, 72.92581199999995);

    var mapOptions = {
        zoom: 5,
        center: myPosition,
        mapTypeId: 'terrain'
    };

    var map = new google.maps.Map(document.getElementById('map'),
        mapOptions);

    var cascadiaFault = new google.maps.Polyline({
        path: [
        //source and destination
        new google.maps.LatLng(19.12182, 72.92596579940823),
        new google.maps.LatLng(19.130813216059188,72.94500260177506),
        // new google.maps.LatLng(19.0938, 72.9226)
        ]
    });

    cascadiaFault.setMap(map);

    if (google.maps.geometry.poly.isLocationOnEdge(myPosition, cascadiaFault, 0.01)) {
        console.log("--> " + google.maps.geometry.poly.isLocationOnEdge(myPosition, cascadiaFault, 10e-1));
        console.log("cascadiaFault : " +  cascadiaFault);
    }else{
    console.log("not in way");
    console.log("cascadiaFault : " +  cascadiaFault);
    }
    }      


   

$( document ).ready(function() {
    $('.some_class').datetimepicker({
        step:30
    });
    $('#date_find').datetimepicker({
        onGenerate:function( ct ){
            $(this).find('.xdsoft_date.xdsoft_weekend')
                .addClass('xdsoft_disabled');
        },
        format:"d:m:y H:m",
        weekends:['01.01.2014','02.01.2014','03.01.2014','04.01.2014','05.01.2014','06.01.2014'],
        timepicker:true
    });
     $('#date_find').datetimepicker({
        onGenerate:function( ct ){
            $(this).find('.xdsoft_date.xdsoft_weekend')
                .addClass('xdsoft_disabled');
        },
        weekends:['01.01.2014','02.01.2014','03.01.2014','04.01.2014','05.01.2014','06.01.2014'],
        timepicker:true
    });
    var logic = function( currentDateTime ){
        if (currentDateTime && currentDateTime.getDay() == 6){
            this.setOptions({
                minTime:'11:00'
            });
        }else
            this.setOptions({
                minTime:'8:00'
            });
    };  

    $('#date_find').change(function(){
        $(this).attr('value', $('#date_find').val());
    });  

   
});


function getLanLtd(address){
var urladd = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=AIzaSyCtih2BpQD5Y3oEsQokyEzyuiuG7u_JfxE";
                $.ajax({
                   url: urladd,
                   error: function() {
                                  $('#info').html("ERROR");
                   },
                   success: function(data) {
                   console.log(data);
                                  var x = getLT(data); 
                                //console.log("x -- > " + JSON.stringify(x));                
                                return x;
                   },
                   type: 'GET'
                });

}

function getLT(data) {
        var obj = data;
        var a = obj["results"][0];
        var lat = a["geometry"]["location"]["lat"];
        var lng = a["geometry"]["location"]["lng"];
        var map = {};
        map["lat"] = lat;
        map["lng"] = lng;
        return map;
} 



var webGlObject = (function() { 
  return { 
    isOnRoute: function(lat1, lng1, lat2, lng2, myPosLat, myPosLng) {
                  
                 
  //cutomer destination
  var myPosition = new google.maps.LatLng(myPosLat, myPosLng);

  var cascadiaFault = new google.maps.Polyline({
    path: [
                //source and destination
      new google.maps.LatLng(lat1, lng1),
      new google.maps.LatLng(lat2,lng2),
                ]
  });

  //cascadiaFault.setMap(map);

  if (google.maps.geometry.poly.isLocationOnEdge(myPosition, cascadiaFault, 0.015)) {
    console.log("On the way");
    return true;
  }else{
    console.log("Not on way");
    return false;
  }
}
  } 
})(webGlObject||{})
