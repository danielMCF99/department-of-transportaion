package com.api_failover.model.taxi.ride.location.view;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class TaxiRideLocationViewPK {

  private Long taxi_ride_id;

  private Long location_id;

  // Default constructor
  public TaxiRideLocationViewPK() {
  }

  // Getters and Setters
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

  // Override equals and hashCode for composite key functionality
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    TaxiRideLocationViewPK that = (TaxiRideLocationViewPK) o;
    return Objects.equals(taxi_ride_id, that.taxi_ride_id) &&
        Objects.equals(location_id, that.location_id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxi_ride_id, location_id);
  }
}
