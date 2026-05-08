package com.petproject.authservice.validator;

import com.petproject.authservice.dto.RegisterRequestDto;

public interface UserCredentialsValidator {
    void validateUserCredentials(final RegisterRequestDto registerRequestDto);
}