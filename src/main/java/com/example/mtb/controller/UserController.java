package com.example.mtb.controller;


import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.service.UserService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.StructureResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StructureResponseBuilder structureResponseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@Valid @RequestBody UserRegistrationRequest request){
        UserResponse userResponse =userService.userRegister(request);
        return StructureResponseBuilder.success(HttpStatus.CREATED,"user Registration successfully done",userResponse);
    }

    @PutMapping("/profile")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUser(
            @Valid @RequestBody UserRequest userRequest,
            @RequestParam String email) {

        UserResponse userResponse = userService.updateUser(userRequest, email);
        return structureResponseBuilder.success(HttpStatus.OK, "User updated successfully", userResponse);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseStructure<UserResponse>> deleteUser(@RequestParam String email){
        UserResponse userResponse = userService.deleteUser(email);
        return structureResponseBuilder.success(HttpStatus.OK, "User Deleted Successfully", userResponse);
    }
}
