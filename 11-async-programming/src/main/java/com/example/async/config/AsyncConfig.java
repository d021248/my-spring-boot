package com.example.async.config;

import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.concurrent.Executor;

/**
 * Async configuration with thread pool and task decorators
 * 
 * NEW in Spring Framework 7: Multiple TaskDecorator beans are automatically
 * composed in order. Each decorator wraps the previous one.
 */
@Configuration
public class AsyncConfig {

    /**
     * Custom thread pool for async tasks
     */
    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("async-");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        executor.initialize();
        return executor;
    }

    /**
     * Logging TaskDecorator (executes second, wraps MDC decorator)
     * 
     * NEW in Spring Framework 7: Multiple TaskDecorator beans are automatically
     * chained based on @Order annotation
     */
    @Bean
    @Order(2)
    public TaskDecorator loggingTaskDecorator() {
        return runnable -> () -> {
            long startTime = System.currentTimeMillis();
            String threadName = Thread.currentThread().getName();
            
            System.out.println("[TaskDecorator] Starting task in thread: " + threadName);
            try {
                runnable.run();
            } finally {
                long duration = System.currentTimeMillis() - startTime;
                System.out.println("[TaskDecorator] Completed task in " + duration + "ms (thread: " + threadName + ")");
            }
        };
    }

    /**
     * MDC TaskDecorator (executes first, propagates logging context)
     * 
     * MDC (Mapped Diagnostic Context) allows you to put contextual information
     * into logs, which is especially useful in async/multi-threaded environments
     */
    @Bean
    @Order(1)
    public TaskDecorator mdcTaskDecorator() {
        return runnable -> {
            // Capture MDC context from parent thread
            Map<String, String> contextMap = MDC.getCopyOfContextMap();
            
            return () -> {
                try {
                    // Restore MDC context in async thread
                    if (contextMap != null) {
                        MDC.setContextMap(contextMap);
                    }
                    runnable.run();
                } finally {
                    // Clean up MDC
                    MDC.clear();
                }
            };
        };
    }

    /**
     * Metrics TaskDecorator (executes third, records metrics)
     */
    @Bean
    @Order(3)
    public TaskDecorator metricsTaskDecorator() {
        return runnable -> () -> {
            String taskId = "task-" + System.nanoTime();
            System.out.println("[Metrics] Task " + taskId + " submitted");
            
            try {
                runnable.run();
                System.out.println("[Metrics] Task " + taskId + " completed successfully");
            } catch (Exception e) {
                System.out.println("[Metrics] Task " + taskId + " failed: " + e.getMessage());
                throw e;
            }
        };
    }
}
