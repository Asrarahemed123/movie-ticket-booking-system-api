package com.example.mtb.service;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserRequest;
import com.example.mtb.dto.UserResponse;



public interface UserService {
     public UserResponse userRegister(UserRegistrationRequest userDetails);


     UserResponse updateUser(UserRequest userRequest, String email);

     UserResponse deleteUser(String email);
}
