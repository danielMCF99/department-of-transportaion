package com.api_failover.controller.taxi.ride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api_failover.dto.taxi.ride.TaxiRideDTO;
import com.api_failover.service.taxi.ride.TaxiRideService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TaxiRideController {

  @Autowired
  private TaxiRideService taxiRideService;

  @Operation(summary = "Get TaxiRide by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful response"),
      @ApiResponse(responseCode = "404", description = "Entity Not Found")
  })
  @GetMapping("/taxi-ride/{id}")
  public ResponseEntity<TaxiRideDTO> helloWorld(@RequestParam Long id) {
    TaxiRideDTO response = taxiRideService.getTaxiRideById(id);
    return ResponseEntity.ok(response);
  }

}
