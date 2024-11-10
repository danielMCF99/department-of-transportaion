package com.api_failover.service.taxi.ride.location.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_failover.dto.taxi.ride.TaxiRideCreationDTO;
import com.api_failover.dto.taxi.ride.location.TaxiRideLocationCreationDTO;
import com.api_failover.model.location.Location;
import com.api_failover.model.taxi.ride.TaxiRide;
import com.api_failover.model.taxi.ride.location.TaxiRideLocation;
import com.api_failover.model.taxi.ride.location.TaxiRideLocationPK;
import com.api_failover.repository.taxi.ride.location.TaxiRideLocationRepository;
import com.api_failover.service.location.LocationService;
import com.api_failover.service.taxi.ride.location.TaxiRideLocationService;

import jakarta.transaction.Transactional;

@Service
public class TaxiRideLocationServiceImpl implements TaxiRideLocationService {

  @Autowired
  private LocationService locationService;

  @Autowired
  private TaxiRideLocationRepository taxiRideLocationRepository;

  /**
   * Method used to store Taxi Ride and Location associations in the database
   * 
   * @param taxiRideId
   * @param startLocationId
   * @param endLocationId
   * @param creationDTO
   */
  @Transactional
  public void storeTaxiRideLocationsInDatabase(TaxiRide taxiRide, Location startLocation, Location endLocation,
      TaxiRideCreationDTO creationDTO) {

    // List to store the new TaxiRideLocations to be stored in the database
    List<TaxiRideLocation> lTaxiRideLocations = new ArrayList<>();

    // Store Initial Location association
    TaxiRideLocation taxiRideLocationStart = new TaxiRideLocation();
    taxiRideLocationStart.setId(new TaxiRideLocationPK(taxiRide.getId(), startLocation.getId()));
    taxiRideLocationStart.setStartLocation(true);
    taxiRideLocationStart.setEndLocation(false);

    lTaxiRideLocations.add(taxiRideLocationStart);

    // Store Final Location association
    TaxiRideLocation taxiRideLocationEnd = new TaxiRideLocation();
    taxiRideLocationEnd.setId(new TaxiRideLocationPK(taxiRide.getId(), endLocation.getId()));
    taxiRideLocationEnd.setStartLocation(false);
    taxiRideLocationEnd.setEndLocation(true);

    lTaxiRideLocations.add(taxiRideLocationEnd);

    // Store rest of Locations association
    for (TaxiRideLocationCreationDTO elem : creationDTO.getImportant_places()) {

      Location newLocation = locationService.storeLocationInDatabase(elem);
      TaxiRideLocation newTaxiRideLocation = new TaxiRideLocation();

      newTaxiRideLocation.setId(new TaxiRideLocationPK(taxiRide.getId(), newLocation.getId()));
      newTaxiRideLocation.setStartLocation(false);
      newTaxiRideLocation.setEndLocation(false);

      lTaxiRideLocations.add(newTaxiRideLocation);
    }

    // Perform the save in the database
    taxiRideLocationRepository.saveAll(lTaxiRideLocations);
  }

}
