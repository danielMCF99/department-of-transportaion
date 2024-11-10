package com.api_failover.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_failover.model.location.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
