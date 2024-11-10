package com.api_failover.repository.taxi.ride.location.view;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_failover.model.taxi.ride.location.view.TaxiRideLocationView;
import com.api_failover.model.taxi.ride.location.view.TaxiRideLocationViewPK;

public interface TaxiRideLocationViewRepository extends JpaRepository<TaxiRideLocationView, TaxiRideLocationViewPK> {

  List<TaxiRideLocationView> findAllByTaxiRideId(Long taxi_ride_id);
}
