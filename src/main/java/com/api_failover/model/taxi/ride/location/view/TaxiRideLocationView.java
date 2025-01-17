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
  private Boolean startLocation;

  @Column(name = "end_location")
  private Boolean endLocation;

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

  public Boolean getStartLocation() {
    return startLocation;
  }

  public void setStartLocation(Boolean startLocation) {
    this.startLocation = startLocation;
  }

  public Boolean getEndLocation() {
    return endLocation;
  }

  public void setEndLocation(Boolean endLocation) {
    this.endLocation = endLocation;
  }

  public Long getTaxiRideId() {
    return taxiRideId;
  }

  public void setTaxiRideId(Long taxiRideId) {
    this.taxiRideId = taxiRideId;
  }
}
