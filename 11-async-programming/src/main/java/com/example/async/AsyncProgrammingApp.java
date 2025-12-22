package com.example.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Asynchronous Programming Demo
 * 
 * Demonstrates:
 * - @Async annotation for asynchronous method execution
 * - @EnableAsync to enable async processing
 * - CompletableFuture for async results
 * - TaskExecutor configuration
 * - TaskDecorator for context propagation (Spring Framework 7)
 * - Multiple TaskDecorator beans (NEW in Spring Framework 7)
 * - @EventListener with @Async for async event processing
 * - Exception handling in async methods
 * - Thread pool configuration
 * 
 * Key Concepts:
 * - Async methods run in a separate thread pool
 * - Return types: void, Future, CompletableFuture, ListenableFuture
 * - TaskDecorators can propagate context (security, MDC, etc.)
 * - Multiple decorators are automatically chained in Spring Framework 7
 * 
 * Endpoints:
 * - POST /api/tasks/process - Submit async task
 * - GET  /api/tasks/{id} - Check task status
 * - POST /api/email/send - Send email asynchronously
 * - GET  /api/data/parallel - Fetch data from multiple sources in parallel
 * - POST /api/events/publish - Publish event for async processing
 */
@SpringBootApplication
@EnableAsync
public class AsyncProgrammingApp {

    public static void main(String[] args) {
        SpringApplication.run(AsyncProgrammingApp.class, args);
    }
}
