package com.api_failover.repository.taxi.ride;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api_failover.model.taxi.ride.TaxiRide;

public interface TaxiRideRepository extends JpaRepository<TaxiRide, Long> {

  Optional<TaxiRide> findById(Long id);

  /**
   * Used when both minPrice and maxPrice are given as query parameters
   * 
   * @param minPrice
   * @param maxPrice
   * @param pageable
   * @return
   */
  List<TaxiRide> findAllByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
}
