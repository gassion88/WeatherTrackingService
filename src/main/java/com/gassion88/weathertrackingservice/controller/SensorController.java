package com.gassion88.weathertrackingservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gassion88.weathertrackingservice.dto.SensorRegistrationRequestDTO;
import com.gassion88.weathertrackingservice.model.Sensor;
import com.gassion88.weathertrackingservice.service.SensorService;
import com.gassion88.weathertrackingservice.util.error.SensorNotCreatedException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/sensor")
public class SensorController {

    private final ObjectMapper objectMapper;
    private final SensorService sensorService;

    @Autowired
    public SensorController(ObjectMapper objectMapper, SensorService sensorService) {
        this.objectMapper = objectMapper;
        this.sensorService = sensorService;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> scannerRegister(@Valid @RequestBody SensorRegistrationRequestDTO sensorDTO,
                                                      BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldError("name").getDefaultMessage();

            throw new SensorNotCreatedException(errorMessage);
        }

        Sensor sensor = objectMapper.convertValue(sensorDTO, Sensor.class);

        sensorService.registerSensor(sensor);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
