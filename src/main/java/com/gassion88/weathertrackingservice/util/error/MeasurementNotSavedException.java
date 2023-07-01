package com.gassion88.weathertrackingservice.util.error;

public class MeasurementNotSavedException extends RuntimeException {
    public MeasurementNotSavedException(String message) {
        super(message);
    }
}
