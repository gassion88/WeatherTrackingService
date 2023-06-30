package com.gassion88.weathertrackingservice.util.error_handler;

import com.gassion88.weathertrackingservice.dto.ErrorResponseDTO;
import com.gassion88.weathertrackingservice.util.error.SensorIsAlreadyRegisteredException;
import com.gassion88.weathertrackingservice.util.error.SensorNotCreatedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ SensorIsAlreadyRegisteredException.class })
    public ResponseEntity<ErrorResponseDTO> handleSensorIsAlreadyRegisteredException (
            Exception ex) {
        return new ResponseEntity<>(new ErrorResponseDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ SensorNotCreatedException.class })
    public ResponseEntity<ErrorResponseDTO> handleSensorNotCreatedException (
            Exception ex) {
        return new ResponseEntity<>(
                new ErrorResponseDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
