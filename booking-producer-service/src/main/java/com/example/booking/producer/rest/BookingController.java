package com.example.booking.producer.rest;

import static com.example.booking.producer.rest.BookingController.BOOKING_PATH;

import com.example.booking.dto.BookingDto;
import com.example.booking.producer.exception.BookingNotFoundException;
import com.example.booking.producer.service.BookingService;
import java.net.URI;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BOOKING_PATH)
public class BookingController {

  public static final String BOOKING_PATH = "/booking";
  private static final String BOOKING_LOCATION_PATTERN = BOOKING_PATH + "/%s";

  private final BookingService bookingService;

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @PostMapping
  public ResponseEntity<?> add(@RequestBody @Valid BookingDto bookingDto) {
    String bookingId = bookingService.add(bookingDto);
    return ResponseEntity.accepted()
        .location(getBookingLocation(bookingId))
        .build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookingDto> get(@PathVariable("id") String id) {
    Optional<BookingDto> bookingOptional = bookingService.get(id);
    if (bookingOptional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(bookingOptional.get());
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(
      @PathVariable("id") String id,
      @RequestBody @Valid BookingDto bookingDto
  ) {
    try {
      bookingService.update(id, bookingDto);
    } catch (BookingNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.accepted().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable("id") String id) {
    try {
      bookingService.delete(id);
    } catch (BookingNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.accepted().build();
  }

  private URI getBookingLocation(String bookingId) {
    return URI.create(String.format(BOOKING_LOCATION_PATTERN, bookingId));
  }

}
