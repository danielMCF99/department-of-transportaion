package com.api_failover.model.taxi.ride.location;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "taxi_ride_location")
public class TaxiRideLocation {

  @EmbeddedId
  private TaxiRideLocationPK id;

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
