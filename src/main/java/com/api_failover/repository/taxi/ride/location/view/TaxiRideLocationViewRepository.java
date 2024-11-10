package com.api_failover.repository.taxi.ride.location.view;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api_failover.model.taxi.ride.location.view.TaxiRideLocationView;
import com.api_failover.model.taxi.ride.location.view.TaxiRideLocationViewPK;

public interface TaxiRideLocationViewRepository extends JpaRepository<TaxiRideLocationView, TaxiRideLocationViewPK> {

  /**
   * Used when both minPrice and maxPrice are given as query parameters
   * 
   * @param minPrice
   * @param maxPrice
   * @param pageable
   * @return
   */
  List<TaxiRideLocationView> findAllByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
}
