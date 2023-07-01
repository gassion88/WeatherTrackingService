package com.gassion88.weathertrackingservice.service.Implementation;

import com.gassion88.weathertrackingservice.model.Sensor;
import com.gassion88.weathertrackingservice.repository.SensorRepository;
import com.gassion88.weathertrackingservice.service.SensorService;
import com.gassion88.weathertrackingservice.util.error.SensorIsAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public void registerSensor(Sensor sensor) {
        if(isSensorRegistered(sensor.getName())) {
            throw new SensorIsAlreadyRegisteredException();
        }

        sensorRepository.save(sensor);
    }

    @Override
    public boolean isSensorRegistered(String sensorName) {
        return sensorRepository.findByName(sensorName).isPresent();
    }
}
