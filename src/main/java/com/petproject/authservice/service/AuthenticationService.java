package com.petproject.authservice.service;

import com.petproject.authservice.dto.RegisterRequestDto;

public interface AuthenticationService {
    void register(final RegisterRequestDto registerRequestDto);
}