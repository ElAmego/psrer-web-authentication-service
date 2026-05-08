package com.petproject.authservice.model.repository;

import com.petproject.authservice.model.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
    boolean existsByEmail(final String email);
    boolean existsByUserId(final Long userid);
}