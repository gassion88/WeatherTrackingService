package com.gassion88.weathertrackingservice.util.error;

public class SensorNotRegisteredException extends RuntimeException {
    public SensorNotRegisteredException() {
        super("This sensor is not registered");
    }
}
