package com.api_failover.service.location;

import com.api_failover.dto.taxi.ride.location.TaxiRideLocationCreationDTO;
import com.api_failover.model.location.Location;

public interface LocationService {

  Location storeLocationInDatabase(TaxiRideLocationCreationDTO taxiRideLocationCreationDTO);
}
