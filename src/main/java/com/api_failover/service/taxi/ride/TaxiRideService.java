package com.api_failover.service.taxi.ride;

import java.util.List;

import com.api_failover.dto.taxi.ride.TaxiRideCreationDTO;
import com.api_failover.dto.taxi.ride.TaxiRideDTO;
import com.api_failover.dto.taxi.ride.TaxiRideQueryRequest;
import com.api_failover.model.taxi.ride.TaxiRide;

public interface TaxiRideService {

  TaxiRide storeTaxiRideInDatabase(TaxiRideCreationDTO taxiRideCreationDTO);

  List<TaxiRideDTO> findAllWithPriceBetween(TaxiRideQueryRequest queryRequest);
}
