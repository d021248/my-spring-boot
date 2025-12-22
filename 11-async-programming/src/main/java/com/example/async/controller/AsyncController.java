package com.example.async.controller;

import com.example.async.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Controller demonstrating async operations
 */
@RestController
@RequestMapping("/api")
public class AsyncController {

    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);
    private final AsyncService asyncService;

    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    /**
     * Submit async task (fire and forget)
     */
    @PostMapping("/tasks/process")
    public Map<String, String> processTask() {
        String taskId = UUID.randomUUID().toString();
        
        // Set MDC context (will be propagated to async thread via TaskDecorator)
        MDC.put("taskId", taskId);
        MDC.put("userId", "user-123");
        
        log.info("Submitting task for async processing");
        asyncService.processTaskAsync(taskId);
        
        return Map.of(
            "taskId", taskId,
            "status", "submitted",
            "message", "Task submitted for async processing"
        );
    }

    /**
     * Send email asynchronously
     */
    @PostMapping("/email/send")
    public CompletableFuture<Map<String, Object>> sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body) {
        
        log.info("Received email request for: {}", to);
        
        return asyncService.sendEmailAsync(to, subject, body)
            .thenApply(success -> {
                Map<String, Object> response = new HashMap<>();
                response.put("to", to);
                response.put("status", success ? "sent" : "failed");
                response.put("timestamp", System.currentTimeMillis());
                return response;
            });
    }

    /**
     * Fetch data from multiple sources in parallel
     */
    @GetMapping("/data/parallel")
    public CompletableFuture<Map<String, Object>> fetchDataInParallel() {
        log.info("Fetching data from multiple sources in parallel");
        
        CompletableFuture<String> source1 = asyncService.fetchDataAsync("API-1");
        CompletableFuture<String> source2 = asyncService.fetchDataAsync("API-2");
        CompletableFuture<String> source3 = asyncService.fetchDataAsync("API-3");
        
        // Combine all futures
        return CompletableFuture.allOf(source1, source2, source3)
            .thenApply(v -> {
                Map<String, Object> result = new HashMap<>();
                result.put("source1", source1.join());
                result.put("source2", source2.join());
                result.put("source3", source3.join());
                result.put("totalSources", 3);
                return result;
            });
    }

    /**
     * Calculate factorials in parallel
     */
    @PostMapping("/calculate/parallel")
    public CompletableFuture<Map<String, Object>> calculateInParallel(@RequestBody List<Integer> numbers) {
        log.info("Calculating factorials for {} numbers in parallel", numbers.size());
        
        List<CompletableFuture<Integer>> futures = numbers.stream()
            .map(asyncService::calculateAsync)
            .toList();
        
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
            .thenApply(v -> {
                Map<String, Object> results = new HashMap<>();
                for (int i = 0; i < numbers.size(); i++) {
                    try {
                        results.put("result_" + numbers.get(i), futures.get(i).join());
                    } catch (Exception e) {
                        results.put("result_" + numbers.get(i), "error: " + e.getMessage());
                    }
                }
                return results;
            });
    }

    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
            "status", "UP",
            "thread", Thread.currentThread().getName()
        );
    }
}
