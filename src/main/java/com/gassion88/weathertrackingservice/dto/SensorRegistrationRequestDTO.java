package com.gassion88.weathertrackingservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorRegistrationRequestDTO {
    @NotEmpty(message = "Sensor name must not be empty!")
    @Size(min = 3, max = 30, message = "The sensor name must be between 3 and 30 characters")
    private String name;
}