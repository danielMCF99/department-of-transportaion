package com.api_failover.service.taxi.ride;

import com.api_failover.dto.taxi.ride.TaxiRideCreationDTO;
import com.api_failover.model.taxi.ride.TaxiRide;

public interface TaxiRideService {

  TaxiRide storeTaxiRideInDatabase(TaxiRideCreationDTO taxiRideCreationDTO);
}
