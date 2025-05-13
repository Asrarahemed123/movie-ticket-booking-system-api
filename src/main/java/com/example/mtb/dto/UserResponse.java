package com.example.mtb.dto;

import com.example.mtb.enums.Role;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserResponse(

        @NotNull
        String userName,
        @NotNull
        String email,
        String userDetailsEmail,
        @NotNull
        Role userRole,
        @NotNull
        String phoneNumber,
        LocalDate dateOfBirth
) {
}
