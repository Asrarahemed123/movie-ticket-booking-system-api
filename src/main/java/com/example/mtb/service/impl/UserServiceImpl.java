package com.example.mtb.service.impl;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.Role;
import com.example.mtb.exception.EmailAlreadyExistException;
import com.example.mtb.exception.EmailNotExistException;
import com.example.mtb.mapper.UserMapper;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponse userRegister(UserRegistrationRequest request) {
        if(userRepository.existsByEmail(request.email())){
            throw new EmailAlreadyExistException("user mail already exist"+request.email());
        }
        if(request.role()== Role.USER){
            return userMapper.toResponse(userRepository.save(userMapper.toUser(request)));
        }else{
            return userMapper.toResponse(userRepository.save(userMapper.totheaterOwner(request)));
        }
    }

    @Override
    public UserResponse updateUser(UserRequest request, String email) {
        UserDetails userDetails = userRepository.findByEmail(email);
        if (userDetails == null) {
            System.out.println("firstt");
            throw new EmailNotExistException("user mail not exist " + email);
        }else if (userDetails.isDelete()){
            System.out.println("second");
            throw new EmailNotExistException("User already deleted");
        }
        System.out.println("three");
        return userMapper.toResponse(userRepository.save(userMapper.toUpdateUserDetails(request, userDetails)));
    }

    @Override
    public UserResponse deleteUser(String email) {
        UserDetails userDetails = userRepository.findByEmail(email);
        if (userDetails == null) {
            throw new EmailNotExistException("user mail not exist " + email);
        }else if(userDetails.isDelete()){
            throw new EmailNotExistException("User already deleted");
        }
        return userMapper.toResponse(userRepository.save(userMapper.toDeleteUserDetails(userDetails)));
    }

}
