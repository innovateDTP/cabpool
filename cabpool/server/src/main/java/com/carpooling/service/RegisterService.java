package com.carpooling.service;

import org.springframework.stereotype.Service;

import com.carpooling.domain.RegisterUser;

@Service
public interface RegisterService {
 public boolean registerUser(RegisterUser user);
 public boolean login(RegisterUser user);
}
