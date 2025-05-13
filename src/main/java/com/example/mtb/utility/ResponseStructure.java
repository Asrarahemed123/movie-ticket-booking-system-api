package com.example.mtb.utility;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Data
public class ResponseStructure<T> {
    private int StatusCode;
    private String Message;
    private T data;
}
