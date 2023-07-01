package com.gassion88.weathertrackingservice.service;

import com.gassion88.weathertrackingservice.model.Sensor;

public interface SensorService {

    void registerSensor(Sensor sensor);

    boolean findSensorByName(String sensorName);

    boolean findSensorById(Long id);
}
