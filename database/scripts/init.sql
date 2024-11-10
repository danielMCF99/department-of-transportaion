CREATE TABLE location (
    id SERIAL PRIMARY KEY,
    latitude DECIMAL(10, 7),
    longitude DECIMAL(10, 7),
    place VARCHAR(255)
);

CREATE TABLE taxi_rides (
    id SERIAL PRIMARY KEY,
    start_date DATE,
    end_date DATE,
    price NUMERIC(10, 2)
);

CREATE TABLE taxi_ride_location (
    taxi_ride_id INT REFERENCES taxi_rides(id) ON DELETE CASCADE,
    location_id INT REFERENCES location(id) ON DELETE CASCADE,
    start_location boolean,
    end_location boolean,
    PRIMARY KEY (taxi_ride_id, location_id)
);