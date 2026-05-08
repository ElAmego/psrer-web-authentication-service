package com.petproject.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {

    @NotNull(message = "userId is required")
    @Positive(message = "userId must be positive")
    private Long userId;

    @NotEmpty(message = "email is required")
    @Email(message = "email must be correct")
    @Size(
            max = 255,
            message = "email mustn't be more than 255 symbols"
    )
    private String email;

    @NotEmpty(message = "password is required")
    @Size(
            max = 255,
            message = "password mustn't be more than 255 symbols"
    )
    private String password;

    private String userRole;
}