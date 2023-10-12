package com.gassion88.weathertrackingservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gassion88.weathertrackingservice.dto.MeasurementResponseDTO;
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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    @GetMapping
    public List<MeasurementResponseDTO> getAllMeasurements() {
        List<Measurement> measurements = measurementService.getAllMeasurements();

        List<MeasurementResponseDTO> responseDTO = new ArrayList<>();
        for (Measurement measurement : measurements) {
            MeasurementResponseDTO measurementResponseDTO = objectMapper.convertValue(measurement, MeasurementResponseDTO.class);
            responseDTO.add(measurementResponseDTO);
        }

        return responseDTO;
    }

    @GetMapping("/rainydayscount")
    public int rainyDaysCount() {
        return measurementService.getRainyDaysCount();
    }
}
