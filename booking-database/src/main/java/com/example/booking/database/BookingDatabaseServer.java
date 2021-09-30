package com.example.booking.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class BookingDatabaseServer {

  public static void main(String[] args) {
    SpringApplication.run(BookingDatabaseServer.class, args);
  }

}
