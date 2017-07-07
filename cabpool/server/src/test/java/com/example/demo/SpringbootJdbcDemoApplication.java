package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.carpooling.domain.RegisterUser;
import com.carpooling.repository.RegisterRepository;
import com.carpooling.starter.CarPoolingApplication;

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(CarPoolingApplication.class)
@SpringBootTest
public class SpringbootJdbcDemoApplication
{
    @Autowired
    private RegisterRepository registerRepository;

    @Test
    public void findAllUsers() {
        List<RegisterUser> users = registerRepository.findAll();
        System.out.println("\n\n data --- ?> " + users.toString());
        //assertNotNull(users);
    }

    @Test
    public void findUserById() {
    	RegisterUser user = registerRepository.findUserById(1);
        //assertNotNull(user);
    }

    @Test
    public void registerUser() {
    	RegisterUser user = new RegisterUser();
    	user.setEmp_id(29699);
    	user.setEmp_name("ABC");
    	user.setCont_no(96541238);
    	user.setAlt_cont_no(965478123);
    	user.setEmail_id("abcd@in.tiaa.org");
    	registerRepository.registerUser(user);
    	findAllUsers();
    }
}
