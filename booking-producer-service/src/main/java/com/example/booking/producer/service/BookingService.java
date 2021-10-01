package com.example.booking.producer.service;

import com.example.booking.dto.BookingDto;
import java.util.Optional;

public interface BookingService {

  String add(BookingDto bookingDto);

  Optional<BookingDto> get(String id);

  void update(String id, BookingDto bookingDto);

  void delete(String id);

}
