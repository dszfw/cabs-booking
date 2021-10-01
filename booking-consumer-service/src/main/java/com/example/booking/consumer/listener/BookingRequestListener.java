package com.example.booking.consumer.listener;

import static com.example.booking.messaging.RabbitConfig.QUEUE_BOOKING_ADD;
import static com.example.booking.messaging.RabbitConfig.QUEUE_BOOKING_DELETE;
import static com.example.booking.messaging.RabbitConfig.QUEUE_BOOKING_EDIT;
import static com.example.booking.messaging.RabbitConfig.QUEUE_MESSAGE_AUDIT;

import com.example.booking.consumer.service.BookingService;
import com.example.booking.dto.BookingDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class BookingRequestListener {

  private static final Logger log = LoggerFactory.getLogger(BookingRequestListener.class);

  private final BookingService bookingService;

  public BookingRequestListener(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @RabbitListener(queues = {QUEUE_BOOKING_ADD})
  public void receiveBookingAddMessage(Message<BookingDto> message) {
    BookingDto bookingDto = message.getPayload();
    log.info("Received \"add booking\" request, message: {}", bookingDto);
    bookingService.add(bookingDto);
  }

  @RabbitListener(queues = {QUEUE_BOOKING_EDIT})
  public void receiveBookingEditMessage(Message<BookingDto> message) {
    BookingDto bookingDto = message.getPayload();
    log.info("Received \"edit booking\" request, message: {}", bookingDto);
    bookingService.update(bookingDto);
  }

  @RabbitListener(queues = {QUEUE_BOOKING_DELETE})
  public void receiveBookingDeleteMessage(String bookingId) {
    log.info("Received \"delete booking\" request, bookingId: {}", bookingId);
    bookingService.delete(bookingId);
  }

  @RabbitListener(queues = {QUEUE_MESSAGE_AUDIT})
  public void receiveMessageAudit(Message<?> message) {
    log.info("Audit message: {}", message.getPayload());
  }

}
