package com.example.scheduled.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * Dynamic task scheduler service
 * 
 * Allows scheduling tasks programmatically at runtime
 */
@Service
public class DynamicSchedulerService {

    private static final Logger log = LoggerFactory.getLogger(DynamicSchedulerService.class);
    
    private final TaskScheduler taskScheduler;
    private final Map<String, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap<>();

    public DynamicSchedulerService(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    /**
     * Schedule a task with fixed delay
     */
    public void scheduleTaskWithFixedDelay(String taskName, Runnable task, Duration delay) {
        log.info("Scheduling task '{}' with fixed delay of {} seconds", taskName, delay.getSeconds());
        
        ScheduledFuture<?> scheduledTask = taskScheduler.scheduleWithFixedDelay(
            task,
            Instant.now().plusSeconds(5), // Initial delay
            delay
        );
        
        scheduledTasks.put(taskName, scheduledTask);
    }

    /**
     * Schedule a task with cron expression
     */
    public void scheduleTaskWithCron(String taskName, Runnable task, String cronExpression) {
        log.info("Scheduling task '{}' with cron expression: {}", taskName, cronExpression);
        
        ScheduledFuture<?> scheduledTask = taskScheduler.schedule(
            task,
            new CronTrigger(cronExpression)
        );
        
        scheduledTasks.put(taskName, scheduledTask);
    }

    /**
     * Schedule a one-time task
     */
    public void scheduleOneTimeTask(String taskName, Runnable task, Instant startTime) {
        log.info("Scheduling one-time task '{}' at {}", taskName, startTime);
        
        ScheduledFuture<?> scheduledTask = taskScheduler.schedule(task, startTime);
        scheduledTasks.put(taskName, scheduledTask);
    }

    /**
     * Cancel a scheduled task
     */
    public boolean cancelTask(String taskName) {
        ScheduledFuture<?> scheduledTask = scheduledTasks.get(taskName);
        if (scheduledTask != null) {
            log.info("Cancelling task '{}'", taskName);
            boolean cancelled = scheduledTask.cancel(false);
            scheduledTasks.remove(taskName);
            return cancelled;
        }
        return false;
    }

    /**
     * Get all scheduled task names
     */
    public Map<String, Boolean> getAllTaskStatuses() {
        Map<String, Boolean> statuses = new ConcurrentHashMap<>();
        scheduledTasks.forEach((name, future) -> 
            statuses.put(name, !future.isCancelled() && !future.isDone())
        );
        return statuses;
    }
}
