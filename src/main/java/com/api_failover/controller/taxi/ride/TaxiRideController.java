package com.api_failover.controller.taxi.ride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.api_failover.service.taxi.ride.TaxiRideService;

@RestController
public class TaxiRideController {

  @Autowired
  private TaxiRideService taxiRideService;

}
