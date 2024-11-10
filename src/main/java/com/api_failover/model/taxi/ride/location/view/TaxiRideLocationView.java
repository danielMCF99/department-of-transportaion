package com.api_failover.model.taxi.ride.location.view;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "v_taxi_ride_location")
public class TaxiRideLocationView {

  @EmbeddedId
  private TaxiRideLocationViewPK id;

  @Column(name = "latitude")
  private BigDecimal latitude;

  @Column(name = "longitude")
  private BigDecimal longitude;

  @Column(name = "place")
  private String place;

  @Column(name = "start_location")
  private Boolean start_location;

  @Column(name = "end_location")
  private Boolean end_location;

  @Column(name = "taxi_ride_id", insertable = false, updatable = false)
  private Long taxiRideId;

  public TaxiRideLocationView() {

  }

  public TaxiRideLocationViewPK getId() {
    return id;
  }

  public void setId(TaxiRideLocationViewPK id) {
    this.id = id;
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

  public Long getTaxi_ride_id() {
    return taxiRideId;
  }

  public void setTaxi_ride_id(Long taxi_ride_id) {
    this.taxiRideId = taxi_ride_id;
  }
}
