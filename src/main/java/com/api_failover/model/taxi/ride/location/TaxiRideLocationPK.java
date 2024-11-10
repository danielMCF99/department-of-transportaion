package com.api_failover.model.taxi.ride.location;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class TaxiRideLocationPK {

  private Long taxiRideId;
  private Long locationId;

  // Default constructor
  public TaxiRideLocationPK() {
  }

  // Parameterized constructor
  public TaxiRideLocationPK(Long taxiRideId, Long locationId) {
    this.taxiRideId = taxiRideId;
    this.locationId = locationId;
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
    TaxiRideLocationPK that = (TaxiRideLocationPK) o;
    return Objects.equals(taxiRideId, that.taxiRideId) &&
        Objects.equals(locationId, that.locationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxiRideId, locationId);
  }
}
