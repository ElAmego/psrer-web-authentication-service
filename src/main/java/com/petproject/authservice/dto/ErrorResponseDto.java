package com.petproject.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponseDto(final String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}