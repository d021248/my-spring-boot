package com.example.api.versioning.dto;

/**
 * User DTO V1 using Java Record
 * Demonstrates immutable data transfer object with minimal boilerplate
 */
public record UserDTO(
        Long id,
        String name,
        String email
) {}
