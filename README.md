# department-of-transportation

### Aplication Initialization

To initialize the application you need to have Docker installed on your computer.

After installing Docker, simply go to the base directory of the repository and run "docker-compose up -d" in the terminal. The database and application containers should start from there.

### Development Stages

#### Stage 1 - Creation of the project structure

I created the base structure of the project with the initial dependencies through the https://start.spring.io/ platform.

After this , my main objective was to setup a Containerization mechanism using Dockerfiles and docker-compose. With this in mind I created a Dockerfile for the Spring Boot aplication and saved it in the project initial folder and I created a Dockerfile for the database container and saved this in the "database" folder.

I also created a folder named "scripts" to store the python scripts used for generating random data.

#### Stage 2 - Creation of DataGeneration Service mechanism

With the Containerization completed and having the application launching with "docker-compose up -d".

I started to foccus on the service that will trigger the python script to run and then read data from the gerated JSON file and store in the database.

To trigger the python script to run I created a Scheduled service in the DataGenerationService. The cron expression for this service is also defined in the same file.

Then I created a service that tries to process the data from the JSON file and map it to the Java Entities I defined. After processing this data, everything is added to a Queue.

Finally I created a service that processes this queue and tries to store the respective information into the database. This service also as a Scheduled cron expression to run on.

#### Stage 3 - Creation of the Rest Endpoint to Query Data

To perform queries to the database, I created the TaxiRideLocationView entity which maps to the VIEW created in the database v_taxi_ride_location.

This VIEW is based on the association table that I have name taxi_ride_location. The purpose of this table is to store associatios between a Taxi Ride and the various different Locations that belong to it.

Then I created a simple query service that has a request body "TaxiRideQueryRequest" and then does a research based on the parameters , page and size sent.