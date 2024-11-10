package com.api_failover.dto.taxi.ride;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.api_failover.dto.taxi.ride.location.TaxiRideLocationViewDTO;

public class TaxiRideDTO implements Serializable {

  private Long id;

  private Date startDate;

  private Date endDate;

  private BigDecimal price;

  private List<TaxiRideLocationViewDTO> taxiRideLocations;

  public TaxiRideDTO() {
  }

  public TaxiRideDTO(List<TaxiRideLocationViewDTO> taxiRideLocations) {
    this.taxiRideLocations = taxiRideLocations;
  }

  public Long getId() {
    return id;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<TaxiRideLocationViewDTO> getTaxiRideLocations() {
    return taxiRideLocations;
  }

  public void setTaxiRideLocations(List<TaxiRideLocationViewDTO> taxiRideLocations) {
    this.taxiRideLocations = taxiRideLocations;
  }

}
