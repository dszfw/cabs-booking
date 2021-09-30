package com.example.booking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Booking {

  @Id
  private String id;
  private String passengerName;
  private String passengerContactNumber;
  private LocalDateTime pickupTime;
  private boolean asap;
  private long waitingTime;
  private long numberOfPassengers;
  private BigDecimal price;
  private long rating;
  private LocalDateTime createdOn;
  private LocalDateTime lastModifiedOn;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
      name = "booking_waypoints",
      joinColumns =
      @JoinColumn(name = "booking_id", referencedColumnName = "id"),
      inverseJoinColumns =
      @JoinColumn(name = "waypoint_id", referencedColumnName = "id")
  )
  private List<TripWaypoint> tripWaypoints;

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

  public long getRating() {
    return rating;
  }

  public void setRating(long rating) {
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

  public List<TripWaypoint> getTripWaypoints() {
    return tripWaypoints;
  }

  public void setTripWaypoints(List<TripWaypoint> tripWaypoints) {
    this.tripWaypoints = tripWaypoints;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Booking booking = (Booking) o;
    return id.equals(booking.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
