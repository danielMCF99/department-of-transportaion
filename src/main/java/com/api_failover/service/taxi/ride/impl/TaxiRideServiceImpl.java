package com.api_failover.service.taxi.ride.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_failover.dto.taxi.ride.TaxiRideCreationDTO;
import com.api_failover.model.taxi.ride.TaxiRide;
import com.api_failover.repository.taxi.ride.TaxiRideRepository;
import com.api_failover.service.taxi.ride.TaxiRideService;

import jakarta.transaction.Transactional;

@Service
public class TaxiRideServiceImpl implements TaxiRideService {

  @Autowired
  private TaxiRideRepository taxiRideRepository;

  /**
   * Method used to store a new Taxi Ride in the database
   * 
   * @param taxiRideCreationDTO
   * @return
   */
  @Transactional
  public TaxiRide storeTaxiRideInDatabase(TaxiRideCreationDTO taxiRideCreationDTO) {

    TaxiRide taxiRide = new TaxiRide();
    taxiRide.setStart_date(taxiRideCreationDTO.getStart_date());
    taxiRide.setEnd_date(taxiRideCreationDTO.getEnd_date());
    taxiRide.setPrice(taxiRideCreationDTO.getPrice());

    return taxiRideRepository.save(taxiRide);
  }
}
