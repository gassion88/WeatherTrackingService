package com.gassion88.weathertrackingservice.service.Implementation;

import com.gassion88.weathertrackingservice.dto.MeasurementResponseDTO;
import com.gassion88.weathertrackingservice.model.Measurement;
import com.gassion88.weathertrackingservice.repository.MeasurementRepository;
import com.gassion88.weathertrackingservice.service.MeasurementService;
import com.gassion88.weathertrackingservice.service.SensorService;
import com.gassion88.weathertrackingservice.util.error.SensorNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class MeasurementServiceImpl implements MeasurementService {
    public final MeasurementRepository measurementRepository;

    public final SensorService sensorService;

    @Autowired
    public MeasurementServiceImpl(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    @Override
    public void saveMeasurement(Measurement measurement) {
        measurement.setMeasurementDateTime(new Date());
        measurementRepository.save(measurement);
    }

    @Override
    public int getRainyDaysCount() {
        return 0;
    }

    @Override
    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
//        List<MeasurementResponseDTO> responseDTO = Collections.emptyList();
//
//        for (Measurement measurement : measurements) {
//            MeasurementResponseDTO mappedDTO = o
//            responseDTO.add(ob)
//        }

    }
}
