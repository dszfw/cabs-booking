package com.example.booking.dto;

import java.io.Serializable;

public class TripWaypointDto implements Serializable {

  private long id;
  private String locality;
  private double latitude;
  private double longitude;

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
