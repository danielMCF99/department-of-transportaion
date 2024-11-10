package com.api_failover.dto.taxi.ride;

import java.io.Serializable;
import java.util.List;

public class TaxiRideQueryResponse implements Serializable {

  private List<TaxiRideLocationViewDTO> lTaxiRideLocations;

  public TaxiRideQueryResponse(List<TaxiRideLocationViewDTO> lTaxiRideLocations) {
    this.lTaxiRideLocations = lTaxiRideLocations;
  }

  public List<TaxiRideLocationViewDTO> getlTaxiRideLocations() {
    return lTaxiRideLocations;
  }

  public void setlTaxiRideLocations(List<TaxiRideLocationViewDTO> lTaxiRideLocations) {
    this.lTaxiRideLocations = lTaxiRideLocations;
  }

}
