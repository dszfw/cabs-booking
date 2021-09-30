package com.example.booking.dto.mapper;

import com.example.booking.domain.Booking;
import com.example.booking.dto.BookingDto;
import org.mapstruct.Mapper;

@Mapper
public interface BookingMapper {

  BookingDto bookingToBookingDto(Booking booking);

  Booking bookingDtoToBooking(BookingDto bookingDto);

}
