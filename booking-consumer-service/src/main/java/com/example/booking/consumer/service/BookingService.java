package com.example.booking.consumer.service;

import com.example.booking.dto.BookingDto;

public interface BookingService {

  void add(BookingDto bookingDto);

  void update(BookingDto bookingDto);

  void delete(String bookingId);

}
