package com.api_failover.dto.taxi.ride;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class TaxiRideDTO implements Serializable {

  private Long id;

  private Date startDate;

  private Date endDate;

  private BigDecimal price;

  public TaxiRideDTO() {
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
}
