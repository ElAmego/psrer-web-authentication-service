package com.petproject.authservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "user_credentials")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserCredential extends BaseEntity {

    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "hash_password", nullable = false)
    private String hashPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false, length = 5)
    private UserRole userRole;
}