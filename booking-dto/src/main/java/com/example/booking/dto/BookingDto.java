package com.example.booking.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class BookingDto implements Serializable {

  private String id;
  @NotNull
  private String passengerName;
  @NotNull
  private String passengerContactNumber;
  private LocalDateTime pickupTime;
  private boolean asap;
  private long waitingTime;
  @Min(0)
  @Max(16)
  private long numberOfPassengers;
  @PositiveOrZero
  private BigDecimal price;
  private double rating;
  private LocalDateTime createdOn;
  private LocalDateTime lastModifiedOn;
  @NotNull
  private List<TripWaypointDto> tripWaypoints;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassengerName() {
    return passengerName;
  }

  public void setPassengerName(String passengerName) {
    this.passengerName = passengerName;
  }

  public String getPassengerContactNumber() {
    return passengerContactNumber;
  }

  public void setPassengerContactNumber(String passengerContactNumber) {
    this.passengerContactNumber = passengerContactNumber;
  }

  public LocalDateTime getPickupTime() {
    return pickupTime;
  }

  public void setPickupTime(LocalDateTime pickupTime) {
    this.pickupTime = pickupTime;
  }

  public boolean isAsap() {
    return asap;
  }

  public void setAsap(boolean asap) {
    this.asap = asap;
  }

  public long getWaitingTime() {
    return waitingTime;
  }

  public void setWaitingTime(long waitingTime) {
    this.waitingTime = waitingTime;
  }

  public long getNumberOfPassengers() {
    return numberOfPassengers;
  }

  public void setNumberOfPassengers(long numberOfPassengers) {
    this.numberOfPassengers = numberOfPassengers;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public LocalDateTime getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(LocalDateTime createdOn) {
    this.createdOn = createdOn;
  }

  public LocalDateTime getLastModifiedOn() {
    return lastModifiedOn;
  }

  public void setLastModifiedOn(LocalDateTime lastModifiedOn) {
    this.lastModifiedOn = lastModifiedOn;
  }

  public List<TripWaypointDto> getTripWaypoints() {
    return tripWaypoints;
  }

  public void setTripWaypoints(List<TripWaypointDto> tripWaypoints) {
    this.tripWaypoints = tripWaypoints;
  }

  @Override
  public String toString() {
    return "BookingDto{" +
        "id='" + id + '\'' +
        ", passengerName='" + passengerName + '\'' +
        ", passengerContactNumber='" + passengerContactNumber + '\'' +
        ", pickupTime=" + pickupTime +
        ", asap=" + asap +
        ", waitingTime=" + waitingTime +
        ", numberOfPassengers=" + numberOfPassengers +
        ", price=" + price +
        ", rating=" + rating +
        ", createdOn=" + createdOn +
        ", lastModifiedOn=" + lastModifiedOn +
        ", tripWaypoints=" + tripWaypoints +
        '}';
  }

}
