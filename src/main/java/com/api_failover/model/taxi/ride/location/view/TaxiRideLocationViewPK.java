package com.api_failover.model.taxi.ride.location.view;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TaxiRideLocationViewPK {

  @Column(name = "taxi_ride_id", insertable = false, updatable = false)
  private Long taxiRideId;

  @Column(name = "location_id", insertable = false, updatable = false)
  private Long locationId;

  // Default constructor
  public TaxiRideLocationViewPK() {
  }

  // Getters and Setters
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

  // Override equals and hashCode for composite key functionality
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    TaxiRideLocationViewPK that = (TaxiRideLocationViewPK) o;
    return Objects.equals(taxiRideId, that.taxiRideId) &&
        Objects.equals(locationId, that.locationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxiRideId, locationId);
  }
}
