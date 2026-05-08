package com.petproject.authservice.mapper;

import com.petproject.authservice.dto.RegisterRequestDto;
import com.petproject.authservice.model.entity.UserCredential;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserCredentialMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "hashPassword", ignore = true)
    @Mapping(target = "userRole", source = "userRole")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserCredential toEntity(final RegisterRequestDto registerRequestDto);
}