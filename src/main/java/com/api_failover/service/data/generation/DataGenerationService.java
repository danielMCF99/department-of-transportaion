package com.api_failover.service.data.generation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DataGenerationService {

  private static final Logger logger = LoggerFactory.getLogger(DataGenerationService.class);

  private static final String SCRIPT_PATH = "scripts/generate-data.py";

  /**
   * Service that uses the generate-data python script to generate new data
   * This service has a scheduled based on the cron expression defined
   */
  @Scheduled(cron = "*/30 * * * * *")
  public void generateData() {
    try {

      logger.info("Starting to generate data.");
      // Execute the Python script
      ProcessBuilder processBuilder = new ProcessBuilder("python3", SCRIPT_PATH);
      processBuilder.redirectErrorStream(true); // Merge error and output streams
      Process process = processBuilder.start();

      // Capture the output of the script

      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line); // Print the output for logging purposes
      }

      // Wait for the script to finish
      int exitCode = process.waitFor();
      if (exitCode != 0) {
        logger.info("Python script failed with exit code: " + exitCode);
      } else {
        logger.info("Python script executed successfully");
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.info("Error running Python script: " + e.getMessage());
    }
  }
}
