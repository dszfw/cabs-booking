package com.example.booking.producer.rest;

import static com.example.booking.producer.rest.BookingController.BOOKING_PATH;

import com.example.booking.dao.repo.BookingRepository;
import com.example.booking.domain.Booking;
import com.example.booking.dto.BookingDto;
import com.example.booking.dto.mapper.BookingMapper;
import com.example.booking.messaging.RabbitConfig;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BOOKING_PATH)
public class BookingController {

  public static final String BOOKING_PATH = "/booking";

  private final RabbitTemplate rabbitTemplate;
  private final BookingMapper bookingMapper;
  private final BookingRepository bookingRepository;

  public BookingController(RabbitTemplate rabbitTemplate, BookingMapper bookingMapper,
      BookingRepository bookingRepository) {
    this.rabbitTemplate = rabbitTemplate;
    this.bookingMapper = bookingMapper;
    this.bookingRepository = bookingRepository;
  }

  @PostMapping
  public ResponseEntity<?> add(@RequestBody BookingDto bookingDto) {
    String bookingId = UUID.randomUUID().toString();
    bookingDto.setId(bookingId);
    bookingDto.setCreatedOn(LocalDateTime.now());

    rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_MESSAGE, "booking.add.xyz", bookingDto);

    return ResponseEntity.accepted()
        .location(URI.create(String.format("%s/%s", BOOKING_PATH, bookingId))).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookingDto> get(@PathVariable("id") String id) {
    try {
      Booking booking = bookingRepository.getById(id);
      return ResponseEntity.ok(bookingMapper.bookingToBookingDto(booking));
    } catch (EntityNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

//  private ResponseEntity<ErrorResponseDto> badRequest(String errorMessage) {
//    return ResponseEntity.badRequest().body(new ErrorResponseDto(errorMessage));
//  }

}
