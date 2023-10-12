package com.gassion88.weathertrackingservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gassion88.weathertrackingservice.dto.MeasurementResponseDTO;
import com.gassion88.weathertrackingservice.model.Measurement;
import com.gassion88.weathertrackingservice.model.Sensor;
import com.gassion88.weathertrackingservice.service.MeasurementService;
import com.gassion88.weathertrackingservice.service.SensorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MeasurementControllerTest {

    @Mock
    MeasurementService measurementService;

    @Mock
    SensorService sensorService;

    @Mock
    ObjectMapper objectMapper;

    @InjectMocks
    MeasurementController measurementController;

    @Test
    void saveMeasurement() {
    }

    @Test
    void getAllMeasurements_ReturnsResponseEntity() {
        List<Measurement> measurements = List.of(new Measurement(1, 22.3, true, new Date(), new Sensor(1,  "sensor1")),
                new Measurement(2, 22.3, false, new Date(), new Sensor(1,  "sensor1")));
        doReturn(measurements).when(this.measurementService).getAllMeasurements();
        List<MeasurementResponseDTO> testMeasurements = measurements.stream().map(measurement -> objectMapper.convertValue(measurement, MeasurementResponseDTO.class))
                .toList();

        List<MeasurementResponseDTO> returnMeasurements = this.measurementController.getAllMeasurements();

        assertNotNull(returnMeasurements);
        assertEquals(testMeasurements, returnMeasurements);
    }
}