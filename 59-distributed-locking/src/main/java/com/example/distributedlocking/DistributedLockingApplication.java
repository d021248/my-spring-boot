package com.example.distributedlocking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Distributed Locking Demo Application
 * 
 * ShedLock, distributed coordination
 * 
 * Port: 8139
 * Landing Page: http://localhost:8139
 */
@SpringBootApplication
public class DistributedLockingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedLockingApplication.class, args);
    }
}
