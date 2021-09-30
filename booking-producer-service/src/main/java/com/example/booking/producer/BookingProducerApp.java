package com.example.booking.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.booking")
public class BookingProducerApp {

  public static void main(String[] args) {
    SpringApplication.run(BookingProducerApp.class, args);
  }

}
