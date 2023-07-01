package com.gassion88.weathertrackingservice.service;

import com.gassion88.weathertrackingservice.model.Sensor;

import java.util.Optional;

public interface SensorService {

    void registerSensor(Sensor sensor);

    Optional<Sensor> findSensorByName(String sensorName);

    Optional<Sensor> findSensorById(Long id);
}
