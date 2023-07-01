package com.gassion88.weathertrackingservice.util.error;

public class SensorNotRegisteredException extends RuntimeException {
    public SensorNotRegisteredException() {
        super("This service is not registered");
    }
}
