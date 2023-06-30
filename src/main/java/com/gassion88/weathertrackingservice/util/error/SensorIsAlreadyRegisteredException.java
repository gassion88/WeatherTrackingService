package com.gassion88.weathertrackingservice.util.error;

public class SensorIsAlreadyRegisteredException extends RuntimeException {
    public SensorIsAlreadyRegisteredException() {
        super("This sensor is already registered!");
    }
}
