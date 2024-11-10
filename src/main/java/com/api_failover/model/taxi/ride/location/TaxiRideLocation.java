package com.api_failover.model.taxi.ride.location;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "taxi_ride_location")
public class TaxiRideLocation {

  @EmbeddedId
  private TaxiRideLocationPK id;

  @Column(name = "latitude")
  private Double latitude;

  @Column(name = "longitude")
  private Double longitude;

  @Column(name = "place")
  private String place;

  @Column(name = "start_location")
  private Boolean start_location;

  @Column(name = "end_location")
  private Boolean end_location;

  public TaxiRideLocation() {

  }

  public TaxiRideLocationPK getId() {
    return id;
  }

  public void setId(TaxiRideLocationPK id) {
    this.id = id;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
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
