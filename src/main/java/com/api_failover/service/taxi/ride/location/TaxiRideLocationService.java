package com.api_failover.service.taxi.ride.location;

import com.api_failover.dto.taxi.ride.TaxiRideCreationDTO;
import com.api_failover.model.location.Location;
import com.api_failover.model.taxi.ride.TaxiRide;

public interface TaxiRideLocationService {

  void storeTaxiRideLocationsInDatabase(TaxiRide taxiRide, Location startLocation, Location endLocation,
      TaxiRideCreationDTO creationDTO);
}
