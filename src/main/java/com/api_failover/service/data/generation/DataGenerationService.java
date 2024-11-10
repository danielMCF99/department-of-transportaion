package com.api_failover.service.data.generation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.api_failover.dto.taxi.ride.TaxiRideCreationDTO;
import com.api_failover.model.location.Location;
import com.api_failover.model.taxi.ride.TaxiRide;
import com.api_failover.service.location.LocationService;
import com.api_failover.service.taxi.ride.TaxiRideService;
import com.api_failover.service.taxi.ride.location.TaxiRideLocationService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataGenerationService {

  private static final Logger logger = LoggerFactory.getLogger(DataGenerationService.class);
  private final ObjectMapper objectMapper = new ObjectMapper();

  /**
   * Path to the Python script that generates the random data
   */
  private static final String SCRIPT_PATH = "scripts/generate-data.py";

  /**
   * Path to generated JSON file containing the new data
   */
  private static final String JSON_PATH = "scripts/taxi_records.json";

  @Autowired
  private LocationService locationService;

  @Autowired
  private TaxiRideService taxiRideService;

  @Autowired
  private TaxiRideLocationService taxiRideLocationService;

  /**
   * Queue used to store the data that will be inserted into the Database
   */
  private final BlockingQueue<TaxiRideCreationDTO> queue = new LinkedBlockingQueue<>();

  /**
   * Service that uses the generate-data python script to generate new data
   * This service has a scheduled based on the cron expression defined
   */
  @Scheduled(cron = "0 */10 * * * *")
  public void runScriptForDataGeneration() {
    try {

      logger.info("Starting to generate data.");
      // Execute the Python script
      ProcessBuilder processBuilder = new ProcessBuilder("python3", SCRIPT_PATH);
      processBuilder.redirectErrorStream(true); // Merge error and output streams
      Process process = processBuilder.start();

      // Wait for the script to finish
      int exitCode = process.waitFor();
      if (exitCode != 0) {
        logger.info("Python script failed with exit code: " + exitCode);
      } else {
        logger.info("Python script executed successfully");
        processDataFileIntoQueue();
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.info("Error running Python script: " + e.getMessage());
    }
  }

  /**
   * Method to insert data into the Database.
   * 
   * @param file
   * @throws IOException
   */
  @Retryable(value = IOException.class, maxAttempts = 5, backoff = @Backoff(delay = 5000))
  public void processDataFileIntoQueue() throws IOException {

    logger.info("Started reading JSON file containing random data.");

    // Read data from JSON file and Transform it into TaxiRide objects
    try (FileInputStream fileInputStream = new FileInputStream(JSON_PATH)) {
      List<TaxiRideCreationDTO> records = objectMapper.readValue(fileInputStream,
          new TypeReference<List<TaxiRideCreationDTO>>() {
          });
      queue.addAll(records); // Add parsed records to the queue
    } catch (IOException e) {
      logger.error("Error reading JSON file", e);
    }

    logger.info("Finished reading JSON file containing random data.");
  }

  /**
   * Schedule method to proccess that data from the Queue into the database
   * Should rollback if any kind of Exception occurs.
   */
  @Retryable(value = DataAccessException.class, maxAttempts = 5, backoff = @Backoff(delay = 5000))
  @Scheduled(cron = "0 */3 * * * *")
  public void processQueue() {

    // Iterate through queue while it has elements to be added
    logger.info("Checking queue for new data to be inserted");
    while (!queue.isEmpty()) {
      TaxiRideCreationDTO taxiRideCreationDTO = queue.poll();

      if (taxiRideCreationDTO != null) {

        try {
          Location startLocation = locationService.storeLocationInDatabase(taxiRideCreationDTO.getStart());
          logger.info("Saved TaxiRide start location into database successfully");

          Location endLocation = locationService.storeLocationInDatabase(taxiRideCreationDTO.getEnd());
          logger.info("Saved TaxiRide end location into database successfully");

          TaxiRide taxiRide = taxiRideService.storeTaxiRideInDatabase(taxiRideCreationDTO);
          logger.info("Saved TaxiRide into database successfully");

          taxiRideLocationService.storeTaxiRideLocationsInDatabase(taxiRide, startLocation,
              endLocation,
              taxiRideCreationDTO);
          logger.info("Saved TaxiRideLocation associations into database successfully");
        } catch (DataAccessException e) {

          logger.error("Database still unavailable, requeuing TaxiRide: {}", e);
          queue.offer(taxiRideCreationDTO); // Re-add to queue if save fails
          break;
        }
      }
    }
  }
}
