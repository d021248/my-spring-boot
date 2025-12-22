package com.example.scheduled.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Scheduled tasks demonstrating various scheduling patterns
 */
@Service
public class ScheduledTaskService {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTaskService.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    private final AtomicInteger fixedRateCounter = new AtomicInteger(0);
    private final AtomicInteger fixedDelayCounter = new AtomicInteger(0);
    private final AtomicInteger cronCounter = new AtomicInteger(0);

    /**
     * Fixed Rate: Runs every 5 seconds regardless of previous execution
     * 
     * Use when: Task execution time is predictable and short
     */
    @Scheduled(fixedRate = 5000, initialDelay = 2000)
    public void fixedRateTask() {
        int count = fixedRateCounter.incrementAndGet();
        log.info("[FIXED-RATE] Execution #{} at {}", count, getCurrentTime());
    }

    /**
     * Fixed Delay: Waits 3 seconds after previous execution completes
     * 
     * Use when: You want to ensure a specific gap between executions
     */
    @Scheduled(fixedDelay = 3000, initialDelay = 1000)
    public void fixedDelayTask() {
        int count = fixedDelayCounter.incrementAndGet();
        log.info("[FIXED-DELAY] Execution #{} started at {}", count, getCurrentTime());
        
        try {
            // Simulate work that takes variable time
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        log.info("[FIXED-DELAY] Execution #{} completed at {}", count, getCurrentTime());
    }

    /**
     * Cron: Runs every minute at second 0
     * 
     * Cron format: second minute hour day month weekday
     */
    @Scheduled(cron = "0 * * * * *")
    public void cronTask() {
        int count = cronCounter.incrementAndGet();
        log.info("[CRON] Execution #{} at {}", count, getCurrentTime());
    }

    /**
     * Cron with timezone: Runs every 10 seconds
     */
    @Scheduled(cron = "*/10 * * * * *", zone = "UTC")
    public void cronTaskWithZone() {
        log.info("[CRON-ZONE] Task executed at {} (UTC)", getCurrentTime());
    }

    /**
     * Conditional scheduling: Only runs when property is true
     * 
     * Enable with: app.scheduling.cleanup-enabled=true
     */
    @Scheduled(cron = "0 0 2 * * *") // Daily at 2 AM
    @ConditionalOnProperty(name = "app.scheduling.cleanup-enabled", havingValue = "true", matchIfMissing = false)
    public void dailyCleanupTask() {
        log.info("[CLEANUP] Running daily cleanup at {}", getCurrentTime());
        // Cleanup logic here
    }

    /**
     * Hourly report task
     */
    @Scheduled(cron = "0 0 * * * *") // Every hour
    @ConditionalOnProperty(name = "app.scheduling.reports-enabled", havingValue = "true")
    public void hourlyReportTask() {
        log.info("[REPORT] Generating hourly report at {}", getCurrentTime());
        // Report generation logic
    }

    /**
     * Business hours task: Runs every 30 minutes during business hours (9 AM - 5 PM, weekdays)
     */
    @Scheduled(cron = "0 0/30 9-17 * * MON-FRI")
    @ConditionalOnProperty(name = "app.scheduling.business-hours-task-enabled", havingValue = "true")
    public void businessHoursTask() {
        log.info("[BUSINESS-HOURS] Task executed during business hours at {}", getCurrentTime());
    }

    /**
     * End of day task: Runs at 11:59 PM every day
     */
    @Scheduled(cron = "0 59 23 * * *")
    @ConditionalOnProperty(name = "app.scheduling.end-of-day-enabled", havingValue = "true")
    public void endOfDayTask() {
        log.info("[END-OF-DAY] End of day processing at {}", getCurrentTime());
    }

    /**
     * First day of month task
     */
    @Scheduled(cron = "0 0 9 1 * *") // 9 AM on 1st of every month
    @ConditionalOnProperty(name = "app.scheduling.monthly-task-enabled", havingValue = "true")
    public void monthlyTask() {
        log.info("[MONTHLY] Monthly task executed at {}", getCurrentTime());
    }

    public int getFixedRateCount() {
        return fixedRateCounter.get();
    }

    public int getFixedDelayCount() {
        return fixedDelayCounter.get();
    }

    public int getCronCount() {
        return cronCounter.get();
    }

    private String getCurrentTime() {
        return LocalDateTime.now().format(formatter);
    }
}
