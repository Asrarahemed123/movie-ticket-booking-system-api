package com.example.mtb.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StructureResponseBuilder {

    public static <T>ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data){
        ResponseStructure<T> responseStructure=ResponseStructure.<T>builder().StatusCode(status.value()).Message(message).data(data).build();
        return ResponseEntity.status(status).body(responseStructure);
    }

    public <T> ResponseEntity<ResponseStructure<T>> error(HttpStatus status,String message,T data){
        ResponseStructure<T> responseStructure=ResponseStructure.<T>builder().StatusCode(status.value()).Message(message).data(data).build();
        return ResponseEntity.status(status).body(responseStructure);
    }
}
