package com.api_failover.service.taxi.ride.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api_failover.dto.taxi.ride.TaxiRideCreationDTO;
import com.api_failover.dto.taxi.ride.TaxiRideDTO;
import com.api_failover.dto.taxi.ride.TaxiRideQueryRequest;
import com.api_failover.dto.taxi.ride.location.TaxiRideLocationViewDTO;
import com.api_failover.model.taxi.ride.TaxiRide;
import com.api_failover.model.taxi.ride.location.view.TaxiRideLocationView;
import com.api_failover.repository.taxi.ride.TaxiRideRepository;
import com.api_failover.repository.taxi.ride.location.view.TaxiRideLocationViewRepository;
import com.api_failover.service.data.generation.DataGenerationService;
import com.api_failover.service.taxi.ride.TaxiRideService;

import jakarta.transaction.Transactional;

@Service
public class TaxiRideServiceImpl implements TaxiRideService {

  private static final Logger logger = LoggerFactory.getLogger(DataGenerationService.class);

  @Autowired
  private TaxiRideRepository taxiRideRepository;

  @Autowired
  private TaxiRideLocationViewRepository taxiRideLocationViewRepository;

  /**
   * Service used to store a new Taxi Ride in the database
   * 
   * @param taxiRideCreationDTO
   * @return
   */
  @Transactional
  public TaxiRide storeTaxiRideInDatabase(TaxiRideCreationDTO taxiRideCreationDTO) {

    TaxiRide taxiRide = new TaxiRide();
    taxiRide.setStartDate(taxiRideCreationDTO.getStart_date());
    taxiRide.setEndDate(taxiRideCreationDTO.getEnd_date());
    taxiRide.setPrice(taxiRideCreationDTO.getPrice());

    return taxiRideRepository.save(taxiRide);
  }

  /**
   * Service that looks for Taxi Rides whose price is between the given price
   * range
   */
  public List<TaxiRideDTO> findAllWithPriceBetween(TaxiRideQueryRequest queryRequest) {

    logger.info("Querying database to get Taxi Ride information");
    BigDecimal minPrice = queryRequest.getMinPrice() != null ? queryRequest.getMinPrice() : BigDecimal.ZERO;
    BigDecimal maxPrice = queryRequest.getMaxPrice() != null ? queryRequest.getMaxPrice()
        : BigDecimal.valueOf(Double.MAX_VALUE);

    Pageable pageable = PageRequest.of(queryRequest.getPage(), queryRequest.getSize());

    List<TaxiRideDTO> response = new ArrayList<>();
    try {

      List<TaxiRide> lTaxiRides = taxiRideRepository.findAllByPriceBetween(minPrice,
          maxPrice, pageable);

      if (!lTaxiRides.isEmpty()) {
        for (TaxiRide taxiRide : lTaxiRides) {

          TaxiRideDTO taxiRideDTO = new TaxiRideDTO();
          taxiRideDTO.setId(taxiRide.getId());
          taxiRideDTO.setPrice(taxiRide.getPrice());
          taxiRideDTO.setStartDate(taxiRide.getStartDate());
          taxiRideDTO.setEndDate(taxiRide.getEndDate());

          List<TaxiRideLocationView> lTaxiRideLocation = taxiRideLocationViewRepository
              .findAllByTaxiRideId(taxiRide.getId());

          List<TaxiRideLocationViewDTO> lTaxiRideLocations = lTaxiRideLocation.stream()
              .map(elem -> this.mapElement(elem)).collect(Collectors.toList());

          taxiRideDTO.setTaxiRideLocations(lTaxiRideLocations);
          response.add(taxiRideDTO);
        }
      }
      return response;

    } catch (Exception e) {
      logger.info("Error querying the database for Taxi Ride information");
      return response;
    }
  }

  /**
   * Private method to map element from one Class type to another
   * TODO Improve this to user model mapper in an efficient way
   * 
   * @param elem
   * @return
   */
  private TaxiRideLocationViewDTO mapElement(TaxiRideLocationView elem) {

    logger.info("Entered mapping method");
    TaxiRideLocationViewDTO response = new TaxiRideLocationViewDTO();

    response.setTaxiRideId(elem.getId().getTaxiRideId());
    response.setLocationId(elem.getId().getLocationId());
    response.setStartLocation(elem.getStartLocation());
    response.setEndLocation(elem.getEndLocation());
    response.setLatitude(elem.getLatitude());
    response.setLongitude(elem.getLongitude());
    response.setPlace(elem.getPlace());

    return response;
  }
}
