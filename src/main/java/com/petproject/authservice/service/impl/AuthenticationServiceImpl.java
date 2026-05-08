package com.petproject.authservice.service.impl;

import com.petproject.authservice.dto.RegisterRequestDto;
import com.petproject.authservice.mapper.UserCredentialMapper;
import com.petproject.authservice.model.entity.UserCredential;
import com.petproject.authservice.model.entity.UserRole;
import com.petproject.authservice.model.repository.UserCredentialRepository;
import com.petproject.authservice.validator.UserCredentialsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.petproject.authservice.service.AuthenticationService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserCredentialRepository userCredentialRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserCredentialMapper userCredentialMapper;
    private final UserCredentialsValidator userCredentialsValidator;

    @Override
    public void register(final RegisterRequestDto registerRequestDto) {
        userCredentialsValidator.validateUserCredentials(registerRequestDto);

        final String password = registerRequestDto.getPassword();
        final String hashPassword = passwordEncoder.encode(password);

        final UserCredential userCredential = userCredentialMapper.toEntity(registerRequestDto);
        userCredential.setHashPassword(hashPassword);

        if (registerRequestDto.getUserRole() == null) {
            userCredential.setUserRole(UserRole.USER);
        }

        userCredentialRepository.save(userCredential);
    }
}