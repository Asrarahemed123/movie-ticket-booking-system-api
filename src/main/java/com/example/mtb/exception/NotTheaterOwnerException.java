package com.example.mtb.exception;

public class NotTheaterOwnerException extends RuntimeException {
  public NotTheaterOwnerException(String message) {
    super(message);
  }
}
