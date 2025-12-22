package com.example.async.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Async event listener
 * 
 * Demonstrates async event processing with @EventListener and @Async
 */
@Component
public class TaskEventListener {

    private static final Logger log = LoggerFactory.getLogger(TaskEventListener.class);

    /**
     * Async event listener for TaskEvent
     * 
     * This method runs in a separate thread pool managed by @Async
     */
    @Async
    @EventListener
    public void handleTaskEvent(TaskEvent event) {
        log.info("Async processing of TaskEvent: {} (type: {}) in thread: {}", 
                 event.taskId(), event.type(), Thread.currentThread().getName());
        
        try {
            // Simulate event processing
            TimeUnit.SECONDS.sleep(1);
            log.info("TaskEvent {} processed successfully", event.taskId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("TaskEvent {} processing interrupted", event.taskId());
        }
    }

    /**
     * Multiple listeners for the same event are all invoked asynchronously
     */
    @Async
    @EventListener
    public void logTaskEvent(TaskEvent event) {
        log.info("Logging TaskEvent: {} - {}", event.taskId(), event.message());
    }
}
