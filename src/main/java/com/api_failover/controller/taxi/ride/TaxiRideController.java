package com.api_failover.controller.taxi.ride;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api_failover.dto.taxi.ride.TaxiRideDTO;
import com.api_failover.dto.taxi.ride.TaxiRideQueryRequest;
import com.api_failover.dto.taxi.ride.TaxiRideQueryResponse;
import com.api_failover.service.taxi.ride.TaxiRideService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TaxiRideController {

  @Autowired
  private TaxiRideService taxiRideService;

  @Description(value = "Gets Taxi Ride information from DB based on query parameters")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully performed query request")
  })
  @PostMapping("/taxi-ride/query")
  public ResponseEntity<TaxiRideQueryResponse> postMethodName(@RequestBody TaxiRideQueryRequest queryRequest) {

    List<TaxiRideDTO> lTaxiRideLocations = taxiRideService.findAllWithPriceBetween(queryRequest);
    TaxiRideQueryResponse response = new TaxiRideQueryResponse(lTaxiRideLocations);
    return ResponseEntity.ok(response);
  }

}
