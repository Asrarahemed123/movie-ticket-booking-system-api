package com.example.mtb.service;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserResponse;


public interface UserService {
     public UserResponse userRegister(UserRegistrationRequest userDetails);
}
