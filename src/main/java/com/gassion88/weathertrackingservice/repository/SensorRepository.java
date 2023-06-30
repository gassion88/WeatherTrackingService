package com.gassion88.weathertrackingservice.repository;

import com.gassion88.weathertrackingservice.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
