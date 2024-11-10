package com.api_failover.repository.taxi.ride.location;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_failover.model.taxi.ride.location.TaxiRideLocation;
import com.api_failover.model.taxi.ride.location.TaxiRideLocationPK;

public interface TaxiRideLocationRepository extends JpaRepository<TaxiRideLocation, TaxiRideLocationPK> {

}
