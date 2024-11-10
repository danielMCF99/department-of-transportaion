package com.api_failover.dto.taxi.ride.location;

import java.io.Serializable;
import java.math.BigDecimal;

public class TaxiRideLocationViewDTO implements Serializable {

  private Long taxiRideId;

  private Long locationId;

  private BigDecimal latitude;

  private BigDecimal longitude;

  private String place;

  private Boolean startLocation;

  private Boolean endLocation;

  public TaxiRideLocationViewDTO() {
  }

  public Long getTaxiRideId() {
    return taxiRideId;
  }

  public void setTaxiRideId(Long taxiRideId) {
    this.taxiRideId = taxiRideId;
  }

  public Long getLocationId() {
    return locationId;
  }

  public void setLocationId(Long locationId) {
    this.locationId = locationId;
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

}
