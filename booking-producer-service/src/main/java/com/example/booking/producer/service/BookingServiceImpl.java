package com.example.booking.producer.service;

import com.example.booking.dao.repo.BookingRepository;
import com.example.booking.dto.BookingDto;
import com.example.booking.dto.mapper.BookingMapper;
import com.example.booking.messaging.RabbitConfig;
import com.example.booking.producer.exception.BookingNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

  private static final String BOOKING_ADD_ROUTING_KEY = "booking.add";
  private static final String BOOKING_EDIT_ROUTING_KEY = "booking.edit";
  private static final String BOOKING_DELETE_ROUTING_KEY = "booking.delete";

  private final RabbitTemplate rabbitTemplate;
  private final BookingMapper bookingMapper;
  private final BookingRepository bookingRepository;

  public BookingServiceImpl(RabbitTemplate rabbitTemplate, BookingMapper bookingMapper,
      BookingRepository bookingRepository) {
    this.rabbitTemplate = rabbitTemplate;
    this.bookingMapper = bookingMapper;
    this.bookingRepository = bookingRepository;
  }

  @Override
  public String add(BookingDto bookingDto) {
    String bookingId = UUID.randomUUID().toString();
    bookingDto.setId(bookingId);
    bookingDto.setCreatedOn(LocalDateTime.now());
    sendToRabbit(BOOKING_ADD_ROUTING_KEY, bookingDto);
    return bookingId;
  }

  @Override
  public Optional<BookingDto> get(String id) {
    return bookingRepository.findById(id)
        .map(bookingMapper::bookingToBookingDto);
  }

  @Override
  public void update(String id, BookingDto bookingDto) {
    checkBookingExist(id);
    bookingDto.setId(id);
    sendToRabbit(BOOKING_EDIT_ROUTING_KEY, bookingDto);
  }

  @Override
  public void delete(String id) {
    checkBookingExist(id);
    sendToRabbit(BOOKING_DELETE_ROUTING_KEY, id);
  }

  private void sendToRabbit(String routingKey, Object payload) {
    rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_MESSAGE, routingKey, payload);
  }

  private void checkBookingExist(String id) {
    if (!bookingRepository.existsById(id)) {
      throw new BookingNotFoundException();
    }
  }

}
