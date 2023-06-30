package com.gassion88.weathertrackingservice.repository;

import com.gassion88.weathertrackingservice.model.Measurment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurment, Long> {
}
