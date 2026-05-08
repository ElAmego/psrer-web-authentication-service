package com.petproject.authservice.exception;

import com.petproject.authservice.dto.ErrorResponseDto;
import com.petproject.authservice.exception.custom.RegistrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidation(final MethodArgumentNotValidException exception) {
        final String message = exception.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponseDto(message));
    }

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<ErrorResponseDto> handleRegistration(final RegistrationException exception) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponseDto(exception.getMessage()));
    }
}