package com.example.mtb.utility;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ErrorStructure <T>{
    private int errorCode;
    private String errorMessage;
    private T error;
}
