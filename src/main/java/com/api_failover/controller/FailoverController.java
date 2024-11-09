package com.api_failover.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController()
public class FailoverController {

  @Operation(summary = "Hello World")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful response"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")
  })
  @GetMapping("/hello-world")
  public String helloWorld() {
    return "Hello from the Failover Application";
  }
}
