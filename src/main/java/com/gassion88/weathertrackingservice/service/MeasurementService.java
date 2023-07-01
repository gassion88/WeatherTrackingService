package com.gassion88.weathertrackingservice.service;

import com.gassion88.weathertrackingservice.model.Measurement;

import java.util.List;

public interface MeasurementService {
    void saveMeasurement(Measurement measurement);

    int getRainyDaysCount();

    List<Measurement> getAllMeasurements();
}
