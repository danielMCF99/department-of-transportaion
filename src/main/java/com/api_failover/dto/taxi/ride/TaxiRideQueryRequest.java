package com.api_failover.dto.taxi.ride;

import java.io.Serializable;
import java.math.BigDecimal;

public class TaxiRideQueryRequest implements Serializable {

  private BigDecimal minPrice;

  private BigDecimal maxPrice;

  private int page;

  private int size;

  public TaxiRideQueryRequest() {
  }

  public BigDecimal getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(BigDecimal minPrice) {
    this.minPrice = minPrice;
  }

  public BigDecimal getMaxPrice() {
    return maxPrice;
  }

  public void setMaxPrice(BigDecimal maxPrice) {
    this.maxPrice = maxPrice;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

}
