package com.example.demo;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.carpooling.domain.ProviderDetail;
import com.carpooling.repository.ProviderRepository;
import com.carpooling.repository.RideDetailRepository;
import com.carpooling.service.ProviderService;
import com.carpooling.starter.CarPoolingApplication;

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(CarPoolingApplication.class)
@SpringBootTest
public class ProviderDetailTest
{
    @Autowired
    private ProviderService providerService;

   /* @Test
    public void findAllUsers() {
        List<ProviderDetail> rides = providerRepository.findAll();
        System.out.println("\n\n data --- ?> " + rides.toString());
   }

    @Test
    public void findUserById() {
    	ProviderDetail ride = providerRepository.findUserById(1);
    }
*/

    @Test
    public void provide() {
    	ProviderDetail provider = new ProviderDetail();

    	provider.setAltContact("34544554");
    	provider.setContact("356465");
    	provider.setDate("2017/06/28 21:19");
    	provider.setEmail("sfddfd.dvdv");
    	provider.setEmpId("55556565");
    	provider.setFrom("Godrej one");
    	provider.setNoOfSeats("5");
    	provider.setRoute("Central");
    	provider.setTo("Bhandup west");
    	provider.setVehicleNo("MH45545");
    	provider.setVehType("AC");
    	providerService.enterProviderDetail(provider);
    	provider.setAltContact("386986");
    	provider.setContact("75285");
    	provider.setDate("2017/06/28 11:19");
    	provider.setEmail("sfdfgdfd.dvdv");
    	provider.setEmpId("45353");
    	provider.setFrom("Godrej one");
    	provider.setNoOfSeats("5");
    	provider.setRoute("Central");
    	provider.setTo("Mulund west");
    	provider.setVehicleNo("MH45595");
    	provider.setVehType("AC");
    	providerService.enterProviderDetail(provider);
    	//findAllUsers();
    	provider.setRoute("Central");
    	provider.setDate("2017/06/28 11:19");
    	//System.out.println("Route --> " + providerService.findByRoute(provider).toString());
    	
    }
}