package com.example.core.dto;

import java.time.LocalDateTime;

/**
 * User response DTO using Java Record (Java 16+)
 * Records provide:
 * - Immutability by default
 * - Automatic constructor, getters, equals(), hashCode(), toString()
 * - Compact syntax
 */
public record UserResponse(
        Long id,
        String name,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
