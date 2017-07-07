package com.carpooling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.carpooling.domain.ProviderDetail;
import com.carpooling.service.ProviderService;

@RestController
@RequestMapping("/api/")
public class ProviderController {

	
	 @Autowired
	 ProviderService providerService;
	    
	 @RequestMapping(value = "findByRoute/{route}/{date}", method = RequestMethod.GET)
	    public List<ProviderDetail> getProviders(@PathVariable("route") String route, @PathVariable("date") String date){
	       return providerService.findByRoute(route, date);
	    }

	    @RequestMapping(value = "/enterProviderDetail", method = RequestMethod.POST)
	    public ProviderDetail showBookingDetails(ProviderDetail providerDetail){
	    	return providerService.enterProviderDetail(providerDetail);
	    }    
	    
}
