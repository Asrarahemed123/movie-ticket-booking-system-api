package com.example.mtb.dto;

import com.example.mtb.enums.Role;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.time.LocalDate;


public record UserRequest(


        @NotNull
        @NotBlank
        @Size(min = 3, max = 20)
                String userName,

        @NotNull
        @Pattern(regexp = "^[6-9]\\d{9}$")
        String phoneNumber,

        @NotNull
        @Past
        LocalDate dateOfBirth


) {
}
