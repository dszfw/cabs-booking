package com.example.booking.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.booking")
public class BookingConsumerApp {

  public static void main(String[] args) {
    SpringApplication.run(BookingConsumerApp.class, args);
  }

}
