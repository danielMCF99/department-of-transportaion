package com.api_failover.repository.taxi.ride;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_failover.model.taxi.ride.TaxiRide;

import java.util.Optional;

public interface TaxiRideRepository extends JpaRepository<TaxiRide, Long> {

  Optional<TaxiRide> findById(Long id);
}
