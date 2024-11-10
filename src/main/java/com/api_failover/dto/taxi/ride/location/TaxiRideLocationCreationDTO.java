package com.api_failover.dto.taxi.ride.location;

import java.math.BigDecimal;

public class TaxiRideLocationCreationDTO {

  private BigDecimal latitude;

  private BigDecimal longitude;

  private String place;

  public TaxiRideLocationCreationDTO() {

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

}
