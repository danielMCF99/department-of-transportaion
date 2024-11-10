package com.api_failover.dto.taxi.ride;

import java.io.Serializable;
import java.util.List;

public class TaxiRideQueryResponse implements Serializable {

  private List<TaxiRideDTO> lTaxiRide;

  public TaxiRideQueryResponse(List<TaxiRideDTO> lTaxiRide) {
    this.lTaxiRide = lTaxiRide;
  }

  public List<TaxiRideDTO> getlTaxiRide() {
    return lTaxiRide;
  }

  public void setlTaxiRide(List<TaxiRideDTO> lTaxiRide) {
    this.lTaxiRide = lTaxiRide;
  }

}
