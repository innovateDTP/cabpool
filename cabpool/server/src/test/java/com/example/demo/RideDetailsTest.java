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

import com.carpooling.domain.RideDetails;
import com.carpooling.repository.RideDetailRepository;
import com.carpooling.starter.CarPoolingApplication;

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(CarPoolingApplication.class)
@SpringBootTest
public class RideDetailsTest
{
    @Autowired
    private RideDetailRepository rideDetailRepository;

    @Test
    public void findAllUsers() {
        List<RideDetails> rides = rideDetailRepository.findAll();
        System.out.println("\n\n data --- ?> " + rides.toString());
        //assertNotNull(users);
    }

    @Test
    public void findUserById() {
    	RideDetails ride = rideDetailRepository.findUserById(1);
        //assertNotNull(user);
    }

    @Test
    public void registerUser() {
    	RideDetails ride = new RideDetails();
    	ride.setAvailable_seat_count(5);
    	ride.setDestination_add("Bahndup,mangatram petrol pump");
    	ride.setEmp_id(101);
    	ride.setJourney_date(new Date(2017,07,03));
    	ride.setJourney_time(new Time(15, 30,20));
    	ride.setSource_add("Godrej One Vikroli");
    	ride.setUser_role("User");
    	ride.setVehicle_no("MH2034");
    	rideDetailRepository.bookRide(ride);
    	findAllUsers();
    }
}