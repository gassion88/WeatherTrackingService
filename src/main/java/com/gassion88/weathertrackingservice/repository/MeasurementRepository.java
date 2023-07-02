package com.gassion88.weathertrackingservice.repository;

import com.gassion88.weathertrackingservice.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    int countByRainingTrue();
}
