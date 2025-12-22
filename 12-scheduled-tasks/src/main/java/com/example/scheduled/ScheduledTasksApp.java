package com.example.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Scheduled Tasks Demo
 * 
 * Demonstrates:
 * - @Scheduled annotation for periodic task execution
 * - @EnableScheduling to enable scheduling
 * - Fixed rate vs fixed delay
 * - Cron expressions for complex schedules
 * - Initial delay configuration
 * - Dynamic scheduling with TaskScheduler
 * - Conditional scheduling based on properties
 * - Scheduled task monitoring and management
 * 
 * Scheduling Types:
 * - Fixed Rate: Executes at fixed intervals, regardless of previous execution
 * - Fixed Delay: Waits for specified delay after previous execution completes
 * - Cron: Complex schedules (daily at specific time, weekdays only, etc.)
 * 
 * Common Cron Patterns:
 * - "0 0 * * * *"         - Every hour at minute 0
 * - "0 0 9 * * MON-FRI"   - Weekdays at 9 AM
 * - "0 0/15 * * * *"      - Every 15 minutes
 * - "0 0 0 * * *"         - Daily at midnight
 * - "0 0 12 1 * *"        - First day of month at noon
 * 
 * Endpoints:
 * - GET  /api/scheduler/status - View all scheduled tasks
 * - POST /api/scheduler/enable/{taskName} - Enable specific task
 * - POST /api/scheduler/disable/{taskName} - Disable specific task
 * - GET  /api/scheduler/history - View execution history
 */
@SpringBootApplication
@EnableScheduling
public class ScheduledTasksApp {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledTasksApp.class, args);
    }
}
