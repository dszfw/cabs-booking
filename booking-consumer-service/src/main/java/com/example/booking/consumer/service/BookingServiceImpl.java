package com.example.booking.consumer.service;

import com.example.booking.dao.repo.BookingRepository;
import com.example.booking.dto.BookingDto;
import com.example.booking.dto.mapper.BookingMapper;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

  private final BookingRepository bookingRepository;
  private final BookingMapper bookingMapper;

  public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
    this.bookingRepository = bookingRepository;
    this.bookingMapper = bookingMapper;
  }

  @Override
  public void add(BookingDto bookingDto) {
    bookingRepository.save(bookingMapper.bookingDtoToBooking(bookingDto));
  }

  @Override
  public void update(BookingDto bookingDto) {
    bookingDto.setLastModifiedOn(LocalDateTime.now());
    bookingDto.setCreatedOn(bookingRepository.getById(bookingDto.getId()).getCreatedOn());
    bookingRepository.save(bookingMapper.bookingDtoToBooking(bookingDto));
  }

  @Override
  public void delete(String bookingId) {
    bookingRepository.deleteById(bookingId);
  }

}
