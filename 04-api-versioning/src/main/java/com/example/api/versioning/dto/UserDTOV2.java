package com.example.api.versioning.dto;

/**
 * User DTO V2 using Java Record
 * Enhanced version with firstName/lastName split and phone field
 * Demonstrates API evolution with records
 */
public record UserDTOV2(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone
) {}
