-- Create table for taxi records
CREATE TABLE taxi_records (
    id SERIAL PRIMARY KEY,
    start_latitude DECIMAL(10, 7),
    start_longitude DECIMAL(10, 7),
    start_place VARCHAR(255),
    end_latitude DECIMAL(10, 7),
    end_longitude DECIMAL(10, 7),
    end_place VARCHAR(255),
    start_date DATE,
    end_date DATE,
    price NUMERIC(10, 2)
);

-- Create table for important places related to each taxi record
CREATE TABLE important_places (
    id SERIAL PRIMARY KEY,
    taxi_record_id INT REFERENCES taxi_records(id) ON DELETE CASCADE,
    latitude DECIMAL(10, 7),
    longitude DECIMAL(10, 7),
    place VARCHAR(255)
);