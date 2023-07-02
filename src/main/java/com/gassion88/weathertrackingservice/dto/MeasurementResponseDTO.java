package com.gassion88.weathertrackingservice.dto;

import com.gassion88.weathertrackingservice.model.Sensor;
import lombok.Data;

import java.util.Date;

@Data
public class MeasurementResponseDTO {
    private long id;
    private double value;
    private boolean raining;
    private Date measurementDateTime;
    private Sensor sensor;
}
