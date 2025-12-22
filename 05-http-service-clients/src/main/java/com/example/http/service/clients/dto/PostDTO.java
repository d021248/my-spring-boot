package com.example.http.service.clients.dto;

/**
 * Post DTO using Java Record
 * Demonstrates immutable data structure for HTTP client responses
 */
public record PostDTO(
        Long id,
        Long userId,
        String title,
        String body
) {}
