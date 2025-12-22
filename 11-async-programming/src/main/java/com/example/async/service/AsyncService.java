package com.example.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Service demonstrating various @Async patterns
 */
@Service
public class AsyncService {

    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

    /**
     * Async method with void return (fire and forget)
     */
    @Async
    public void processTaskAsync(String taskId) {
        log.info("Processing task {} in thread: {}", taskId, Thread.currentThread().getName());
        
        try {
            // Simulate long-running task
            TimeUnit.SECONDS.sleep(2);
            log.info("Task {} completed successfully", taskId);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Task {} was interrupted", taskId);
        }
    }

    /**
     * Async method with CompletableFuture return (get result later)
     */
    @Async
    public CompletableFuture<String> fetchDataAsync(String source) {
        log.info("Fetching data from {} in thread: {}", source, Thread.currentThread().getName());
        
        try {
            // Simulate API call
            TimeUnit.SECONDS.sleep(1);
            String result = "Data from " + source;
            log.info("Successfully fetched data from {}", source);
            return CompletableFuture.completedFuture(result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Failed to fetch data from {}", source);
            return CompletableFuture.failedFuture(e);
        }
    }

    /**
     * Async method with exception handling
     */
    @Async
    public CompletableFuture<Integer> calculateAsync(int number) {
        log.info("Calculating factorial of {} in thread: {}", number, Thread.currentThread().getName());
        
        try {
            if (number < 0) {
                throw new IllegalArgumentException("Number must be non-negative");
            }
            
            TimeUnit.MILLISECONDS.sleep(500);
            int result = factorial(number);
            log.info("Calculation completed: {}! = {}", number, result);
            return CompletableFuture.completedFuture(result);
        } catch (Exception e) {
            log.error("Calculation failed for {}: {}", number, e.getMessage());
            return CompletableFuture.failedFuture(e);
        }
    }

    /**
     * Send email asynchronously
     */
    @Async
    public CompletableFuture<Boolean> sendEmailAsync(String to, String subject, String body) {
        log.info("Sending email to {} in thread: {}", to, Thread.currentThread().getName());
        
        try {
            // Simulate email sending
            TimeUnit.SECONDS.sleep(2);
            log.info("Email sent successfully to {}", to);
            return CompletableFuture.completedFuture(true);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Failed to send email to {}", to);
            return CompletableFuture.completedFuture(false);
        }
    }

    private int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
