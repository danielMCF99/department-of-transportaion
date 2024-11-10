package com.api_failover.service.taxi.ride.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api_failover.dto.taxi.ride.TaxiRideCreationDTO;
import com.api_failover.dto.taxi.ride.TaxiRideLocationViewDTO;
import com.api_failover.dto.taxi.ride.TaxiRideQueryRequest;
import com.api_failover.model.taxi.ride.TaxiRide;
import com.api_failover.model.taxi.ride.location.view.TaxiRideLocationView;
import com.api_failover.repository.taxi.ride.TaxiRideRepository;
import com.api_failover.repository.taxi.ride.location.view.TaxiRideLocationViewRepository;
import com.api_failover.service.data.generation.DataGenerationService;
import com.api_failover.service.taxi.ride.TaxiRideService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

@Service
public class TaxiRideServiceImpl implements TaxiRideService {

  private static final Logger logger = LoggerFactory.getLogger(DataGenerationService.class);
  private final ObjectMapper objectMapper = new ObjectMapper();

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
    taxiRide.setStart_date(taxiRideCreationDTO.getStart_date());
    taxiRide.setEnd_date(taxiRideCreationDTO.getEnd_date());
    taxiRide.setPrice(taxiRideCreationDTO.getPrice());

    return taxiRideRepository.save(taxiRide);
  }

  /**
   * Service that looks for Taxi Rides whose price is between the given price
   * range
   */
  public List<TaxiRideLocationViewDTO> findAllWithPriceBetween(TaxiRideQueryRequest queryRequest) {

    logger.info("Querying database to get Taxi Ride information");
    BigDecimal minPrice = queryRequest.getMinPrice() != null ? queryRequest.getMinPrice() : BigDecimal.ZERO;
    BigDecimal maxPrice = queryRequest.getMaxPrice() != null ? queryRequest.getMaxPrice()
        : BigDecimal.valueOf(Double.MAX_VALUE);

    Pageable pageable = PageRequest.of(queryRequest.getPage(), queryRequest.getSize());

    List<TaxiRideLocationViewDTO> response = new ArrayList<>();
    try {
      List<TaxiRideLocationView> lTaxiRideLocation = taxiRideLocationViewRepository.findAllByPriceBetween(minPrice,
          maxPrice, pageable);

      response = lTaxiRideLocation.stream()
          .map(elem -> this.mapElement(elem))
          .collect(Collectors.toList());

      response.sort(Comparator.comparing(TaxiRideLocationViewDTO::getPrice).reversed());
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

    response.setTaxi_ride_id(elem.getId().getTaxi_ride_id());
    response.setLocation_id(elem.getId().getLocation_id());
    response.setStart_location(elem.getStart_location());
    response.setEnd_location(elem.getEnd_location());
    response.setLatitude(elem.getLatitude());
    response.setLongitude(elem.getLongitude());
    response.setPlace(elem.getPlace());
    response.setPrice(elem.getPrice());

    return response;
  }
}
