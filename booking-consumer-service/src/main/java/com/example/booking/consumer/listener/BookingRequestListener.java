package com.example.booking.consumer.listener;

import static com.example.booking.messaging.RabbitConfig.BINDING_PATTERN_BOOKING_ADD;
import static com.example.booking.messaging.RabbitConfig.BINDING_PATTERN_BOOKING_DELETE;
import static com.example.booking.messaging.RabbitConfig.BINDING_PATTERN_BOOKING_EDIT;
import static com.example.booking.messaging.RabbitConfig.QUEUE_BOOKING_ADD;
import static com.example.booking.messaging.RabbitConfig.QUEUE_BOOKING_DELETE;
import static com.example.booking.messaging.RabbitConfig.QUEUE_BOOKING_EDIT;
import static com.example.booking.messaging.RabbitConfig.QUEUE_MESSAGE_AUDIT;

import com.example.booking.dao.repo.BookingRepository;
import com.example.booking.dto.BookingDto;
import com.example.booking.dto.mapper.BookingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class BookingRequestListener {

  private static final Logger log = LoggerFactory.getLogger(BookingRequestListener.class);

  private final BookingRepository bookingRepository;
  private final BookingMapper bookingMapper;

  public BookingRequestListener(BookingRepository bookingRepository, BookingMapper bookingMapper) {
    this.bookingRepository = bookingRepository;
    this.bookingMapper = bookingMapper;
  }

  @RabbitListener(queues = {QUEUE_BOOKING_ADD})
  public void receiveBookingAddMessage(Message<BookingDto> message) {
    BookingDto bookingDto = message.getPayload();
    log.info("Received add booking ({}) message: {}",
        BINDING_PATTERN_BOOKING_ADD, bookingDto);
    bookingRepository.save(bookingMapper.bookingDtoToBooking(bookingDto));
  }

  @RabbitListener(queues = {QUEUE_BOOKING_EDIT})
  public void receiveBookingEditMessage(Message<BookingDto> message) {
    log.info("Received edit booking ({}) message: {}",
        BINDING_PATTERN_BOOKING_EDIT, message.getPayload());
  }

  @RabbitListener(queues = {QUEUE_BOOKING_DELETE})
  public void receiveBookingDeleteMessage(Message<BookingDto> message) {
    log.info("Received delete booking ({}) message: {}",
        BINDING_PATTERN_BOOKING_DELETE, message.getPayload());
  }

  @RabbitListener(queues = {QUEUE_MESSAGE_AUDIT})
  public void receiveMessageAudit(Message<?> message) {
    log.info("Received message: {}", message.getPayload());
  }

}
