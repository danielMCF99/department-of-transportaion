package com.api_failover.model.taxi.ride.location;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "taxi_ride_location")
public class TaxiRideLocation {

  @EmbeddedId
  private TaxiRideLocationPK id;

  @Column(name = "start_location")
  private Boolean startLocation;

  @Column(name = "end_location")
  private Boolean endLocation;

  public TaxiRideLocation() {

  }

  public TaxiRideLocationPK getId() {
    return id;
  }

  public void setId(TaxiRideLocationPK id) {
    this.id = id;
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
