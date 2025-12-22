package com.example.scheduled.controller;

import com.example.scheduled.service.DynamicSchedulerService;
import com.example.scheduled.service.ScheduledTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for managing scheduled tasks
 */
@RestController
@RequestMapping("/api/scheduler")
public class SchedulerController {

    private static final Logger log = LoggerFactory.getLogger(SchedulerController.class);
    
    private final ScheduledTaskService scheduledTaskService;
    private final DynamicSchedulerService dynamicSchedulerService;

    public SchedulerController(ScheduledTaskService scheduledTaskService,
                               DynamicSchedulerService dynamicSchedulerService) {
        this.scheduledTaskService = scheduledTaskService;
        this.dynamicSchedulerService = dynamicSchedulerService;
    }

    /**
     * Get status of all scheduled tasks
     */
    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        Map<String, Object> status = new HashMap<>();
        
        status.put("fixedRateExecutions", scheduledTaskService.getFixedRateCount());
        status.put("fixedDelayExecutions", scheduledTaskService.getFixedDelayCount());
        status.put("cronExecutions", scheduledTaskService.getCronCount());
        status.put("dynamicTasks", dynamicSchedulerService.getAllTaskStatuses());
        
        return status;
    }

    /**
     * Schedule a dynamic task with fixed delay
     */
    @PostMapping("/dynamic/fixed-delay")
    public Map<String, String> scheduleDynamicTask(
            @RequestParam String taskName,
            @RequestParam long delaySeconds) {
        
        Runnable task = () -> log.info("[DYNAMIC-{}] Executing at {}", taskName, Instant.now());
        
        dynamicSchedulerService.scheduleTaskWithFixedDelay(
            taskName,
            task,
            Duration.ofSeconds(delaySeconds)
        );
        
        return Map.of(
            "taskName", taskName,
            "status", "scheduled",
            "delaySeconds", String.valueOf(delaySeconds)
        );
    }

    /**
     * Schedule a dynamic task with cron expression
     */
    @PostMapping("/dynamic/cron")
    public Map<String, String> scheduleDynamicCronTask(
            @RequestParam String taskName,
            @RequestParam String cronExpression) {
        
        Runnable task = () -> log.info("[DYNAMIC-CRON-{}] Executing at {}", taskName, Instant.now());
        
        dynamicSchedulerService.scheduleTaskWithCron(taskName, task, cronExpression);
        
        return Map.of(
            "taskName", taskName,
            "status", "scheduled",
            "cronExpression", cronExpression
        );
    }

    /**
     * Schedule a one-time task
     */
    @PostMapping("/dynamic/one-time")
    public Map<String, String> scheduleOneTimeTask(
            @RequestParam String taskName,
            @RequestParam long delaySeconds) {
        
        Instant startTime = Instant.now().plusSeconds(delaySeconds);
        Runnable task = () -> log.info("[ONE-TIME-{}] Executing at {}", taskName, Instant.now());
        
        dynamicSchedulerService.scheduleOneTimeTask(taskName, task, startTime);
        
        return Map.of(
            "taskName", taskName,
            "status", "scheduled",
            "executeAt", startTime.toString()
        );
    }

    /**
     * Cancel a dynamic task
     */
    @DeleteMapping("/dynamic/{taskName}")
    public Map<String, Object> cancelTask(@PathVariable String taskName) {
        boolean cancelled = dynamicSchedulerService.cancelTask(taskName);
        
        return Map.of(
            "taskName", taskName,
            "cancelled", cancelled
        );
    }

    /**
     * Get all dynamic tasks
     */
    @GetMapping("/dynamic")
    public Map<String, Boolean> getDynamicTasks() {
        return dynamicSchedulerService.getAllTaskStatuses();
    }
}
