package com.gassion88.weathertrackingservice.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SaveMeasurementRequestDTO {

    @NotNull(message = "Значение не может быть пустым")
    @Min(value = -100, message = "Incorrect value")
    @Max(value = 100, message = "Incorrect value")
    //@Size(min = -100.00, max = 100, message = "Incorrect value")
    private double value;

    @NotNull(message = "Raining must not be empty!")
    //@NotNull(message = "Raining must not be empty!")
    private boolean raining;

    private SensorRegistrationRequestDTO sensor;
}
