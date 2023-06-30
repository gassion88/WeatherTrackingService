package com.gassion88.weathertrackingservice.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class ErrorResponseDTO {
    private String message;

    public ErrorResponseDTO(String message) {
        this.message = message;
    }
}
