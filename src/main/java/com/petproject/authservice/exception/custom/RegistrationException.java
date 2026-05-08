package com.petproject.authservice.exception.custom;

public class RegistrationException extends RuntimeException {
    public RegistrationException(final String message) {
        super(message);
    }
}