package com.example.booking.producer.exception;

public class BookingException extends RuntimeException {

  public BookingException() {
  }

  public BookingException(String message) {
    super(message);
  }

  public BookingException(String message, Throwable cause) {
    super(message, cause);
  }

  public BookingException(Throwable cause) {
    super(cause);
  }

}
