package com.gassion88.weathertrackingservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gassion88.weathertrackingservice.dto.SaveMeasurementRequestDTO;
import com.gassion88.weathertrackingservice.model.Measurement;
import com.gassion88.weathertrackingservice.model.Sensor;
import com.gassion88.weathertrackingservice.service.MeasurementService;
import com.gassion88.weathertrackingservice.service.SensorService;
import com.gassion88.weathertrackingservice.util.error.MeasurementNotSavedException;
import com.gassion88.weathertrackingservice.util.error.SensorNotRegisteredException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    private final ObjectMapper objectMapper;

    private final MeasurementService measurementService;

    private final SensorService sensorService;

    @Autowired
    public MeasurementController(ObjectMapper objectMapper, MeasurementService measurementService, SensorService sensorService) {
        this.objectMapper = objectMapper;
        this.measurementService = measurementService;
        this.sensorService = sensorService;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> saveMeasurement(@Valid @RequestBody SaveMeasurementRequestDTO measurementDTO,
                                                      BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
            throw new MeasurementNotSavedException(errorMessage);
        }

        Optional<Sensor> sensor = sensorService.findSensorByName(measurementDTO.getSensor().getName());
        if (sensor.isEmpty()) {
            throw new SensorNotRegisteredException();
        }


        Measurement measurement = objectMapper.convertValue(measurementDTO, Measurement.class);
        measurement.setSensor(sensor.get());
        measurementService.saveMeasurement(measurement);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
