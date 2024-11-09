package com.api_failover.service.taxi.ride;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_failover.dto.taxi.ride.TaxiRideDTO;
import com.api_failover.model.TaxiRide;
import com.api_failover.repository.taxi.ride.TaxiRideRepository;
import com.api_failover.service.file.FileService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaxiRideService {

  private static final Logger logger = LoggerFactory.getLogger(FileService.class);

  @Autowired
  private TaxiRideRepository taxiRideRepository;

  public TaxiRideDTO getTaxiRideById(Long id) {

    logger.info("Entered service to obtain TaxiRide.");

    // Try fetching the TaxiRide from the DB with the given id
    Optional<TaxiRide> result = taxiRideRepository.findById(id);

    // Check if no result was returned
    // If nothing was return then throw EntityNotFoundException
    if (!result.isPresent()) {
      logger.info("Unable to find TaxiRide.");
      throw new EntityNotFoundException("Unable to find TaxiRide");
    }

    logger.info("Found TaxiRide.");
    // Could be improved by using a Model Mapper to map between entity and DTO
    TaxiRideDTO taxiRideDTO = new TaxiRideDTO();
    taxiRideDTO.setStartDate(result.get().getStartDate());
    taxiRideDTO.setEndDate(result.get().getEndDate());
    taxiRideDTO.setPrice(result.get().getPrice());

    return taxiRideDTO;
  }

}
