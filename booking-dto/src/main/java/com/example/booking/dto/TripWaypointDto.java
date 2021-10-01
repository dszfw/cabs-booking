package com.example.booking.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class TripWaypointDto implements Serializable {

  private long id;
  @NotNull
  private String locality;
  private Double latitude;
  private Double longitude;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  @Override
  public String toString() {
    return "TripWaypointDto{" +
        "id=" + id +
        ", locality='" + locality + '\'' +
        ", latitude=" + latitude +
        ", longitude=" + longitude +
        '}';
  }

}
