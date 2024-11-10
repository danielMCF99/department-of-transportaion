CREATE TABLE ride_location (
    id BIGSERIAL PRIMARY KEY,
    latitude DECIMAL(10, 7),
    longitude DECIMAL(10, 7),
    place VARCHAR(255)
);

CREATE TABLE taxi_rides (
    id BIGSERIAL PRIMARY KEY,
    start_date DATE,
    end_date DATE,
    price NUMERIC(10, 2)
);

CREATE TABLE taxi_ride_location (
    taxi_ride_id bigint REFERENCES taxi_rides(id) ON DELETE CASCADE,
    location_id bigint REFERENCES ride_location(id) ON DELETE CASCADE,
    start_location boolean,
    end_location boolean,
    PRIMARY KEY (taxi_ride_id, location_id)
);

DROP VIEW IF EXISTS v_taxi_ride_location;
CREATE OR REPLACE VIEW v_taxi_ride_location AS
SELECT 
    trl.taxi_ride_id,
    tr.price, 
    trl.location_id, 
    trl.start_location, 
    trl.end_location, 
    rl.latitude, 
    rl.longitude, 
    rl.place
FROM taxi_ride_location trl
    LEFT JOIN taxi_rides tr ON tr.id = trl.taxi_ride_id
    LEFT JOIN ride_location rl ON rl.id = trl.location_id;