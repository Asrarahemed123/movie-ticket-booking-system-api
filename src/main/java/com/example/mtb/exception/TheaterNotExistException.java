package com.example.mtb.exception;

public class TheaterNotExistException extends RuntimeException {
  public TheaterNotExistException(String message) {
    super(message);
  }
}
