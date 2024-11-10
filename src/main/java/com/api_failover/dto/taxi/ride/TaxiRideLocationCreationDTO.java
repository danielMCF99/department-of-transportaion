package com.api_failover.dto.taxi.ride;

public class TaxiRideLocationCreationDTO {

  private Double latitude;

  private Double longitude;

  private String place;

  public TaxiRideLocationCreationDTO() {

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

}
