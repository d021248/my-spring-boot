package com.example.transactionmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Transaction Management Demo Application
 * 
 * Transaction propagation, isolation levels, rollback rules
 * 
 * Port: 8094
 * Landing Page: http://localhost:8094
 */
@SpringBootApplication
public class TransactionManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionManagementApplication.class, args);
    }
}
