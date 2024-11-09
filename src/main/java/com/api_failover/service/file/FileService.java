package com.api_failover.service.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_failover.model.TaxiRide;
import com.api_failover.repository.taxi.ride.TaxiRideRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FileService {

  private static final Logger logger = LoggerFactory.getLogger(FileService.class);

  @Autowired
  private TaxiRideRepository taxiRideRepository;

  private final ObjectMapper objectMapper = new ObjectMapper();

  public void processDataFile(File file) throws IOException {

    // Read data from JSON file
    List<TaxiRide> newData = objectMapper.readValue(file,
        objectMapper.getTypeFactory().constructCollectionType(List.class, TaxiRide.class));

    // Persist new data into database
    taxiRideRepository.saveAll(newData);
  }

}
