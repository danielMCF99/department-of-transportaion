package com.api_failover.service.location.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_failover.dto.taxi.ride.TaxiRideLocationCreationDTO;
import com.api_failover.model.location.Location;
import com.api_failover.repository.location.LocationRepository;
import com.api_failover.service.location.LocationService;

import jakarta.transaction.Transactional;

@Service
public class LocationServiceImpl implements LocationService {

  @Autowired
  private LocationRepository locationRepository;

  /**
   * Method used to store a new Location in the database
   * 
   * @param taxiRideLocationCreationDTO
   * @return
   */
  @Transactional
  public Location storeLocationInDatabase(TaxiRideLocationCreationDTO taxiRideLocationCreationDTO) {

    Location location = new Location();
    location.setLatitude(taxiRideLocationCreationDTO.getLatitude());
    location.setLongitude(taxiRideLocationCreationDTO.getLongitude());
    location.setPlace(taxiRideLocationCreationDTO.getPlace());

    return locationRepository.save(location);
  }
}
