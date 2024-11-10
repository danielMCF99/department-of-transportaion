package com.api_failover.dto.taxi.ride;

import java.sql.Date;
import java.util.List;

public class TaxiRideCreationDTO {

  private Date start_date;

  private Date end_date;

  private Double price;

  private TaxiRideLocationCreationDTO start;

  private TaxiRideLocationCreationDTO end;

  private List<TaxiRideLocationCreationDTO> important_places;

  public TaxiRideCreationDTO() {
  }

  public Date getStart_date() {
    return start_date;
  }

  public void setStart_date(Date start_date) {
    this.start_date = start_date;
  }

  public Date getEnd_date() {
    return end_date;
  }

  public void setEnd_date(Date end_date) {
    this.end_date = end_date;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public TaxiRideLocationCreationDTO getStart() {
    return start;
  }

  public void setStart(TaxiRideLocationCreationDTO start) {
    this.start = start;
  }

  public TaxiRideLocationCreationDTO getEnd() {
    return end;
  }

  public void setEnd(TaxiRideLocationCreationDTO end) {
    this.end = end;
  }

  public List<TaxiRideLocationCreationDTO> getImportant_places() {
    return important_places;
  }

  public void setImportant_places(List<TaxiRideLocationCreationDTO> important_places) {
    this.important_places = important_places;
  }
}
