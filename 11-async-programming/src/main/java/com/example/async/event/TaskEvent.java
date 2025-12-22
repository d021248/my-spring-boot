package com.example.async.event;

/**
 * Custom application event
 */
public record TaskEvent(String taskId, String type, String message) {
}
