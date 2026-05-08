package com.petproject.authservice.validator.impl;

import com.petproject.authservice.dto.RegisterRequestDto;
import com.petproject.authservice.exception.custom.RegistrationException;
import com.petproject.authservice.model.repository.UserCredentialRepository;
import com.petproject.authservice.validator.UserCredentialsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCredentialsValidatorImpl implements UserCredentialsValidator {
    private final UserCredentialRepository userCredentialRepository;

    @Override
    public void validateUserCredentials(final RegisterRequestDto registerRequestDto) {
        final String email = registerRequestDto.getEmail();
        validateEmail(email);

        final Long userId = registerRequestDto.getUserId();
        validateUserId(userId);
    }

    private void validateEmail(final String email) {
        if (userCredentialRepository.existsByEmail(email)) {
            throw new RegistrationException("email already exists: " + email);
        }
    }

    private void validateUserId(final Long userId) {
        if (userCredentialRepository.existsByUserId(userId)) {
            throw new RegistrationException("userId already exists: " + userId);
        }
    }
}