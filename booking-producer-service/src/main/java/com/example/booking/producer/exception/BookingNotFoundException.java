package com.example.booking.producer.exception;

public class BookingNotFoundException extends BookingException {

  public BookingNotFoundException() {
  }

  public BookingNotFoundException(String message) {
    super(message);
  }

  public BookingNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public BookingNotFoundException(Throwable cause) {
    super(cause);
  }

}
