package com.api_failover.dto.taxi.ride;

import java.io.Serializable;
import java.math.BigDecimal;

public class TaxiRideLocationViewDTO implements Serializable {

  private Long taxi_ride_id;

  private Long location_id;

  private BigDecimal latitude;

  private BigDecimal longitude;

  private String place;

  private Boolean start_location;

  private Boolean end_location;

  public TaxiRideLocationViewDTO() {
  }

  public Long getTaxi_ride_id() {
    return taxi_ride_id;
  }

  public void setTaxi_ride_id(Long taxi_ride_id) {
    this.taxi_ride_id = taxi_ride_id;
  }

  public Long getLocation_id() {
    return location_id;
  }

  public void setLocation_id(Long location_id) {
    this.location_id = location_id;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public Boolean getStart_location() {
    return start_location;
  }

  public void setStart_location(Boolean start_location) {
    this.start_location = start_location;
  }

  public Boolean getEnd_location() {
    return end_location;
  }

  public void setEnd_location(Boolean end_location) {
    this.end_location = end_location;
  }

}
