package com.example.testing.strategies.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Test Example with JUnit 5
 * 
 * Demonstrates:
 * - @BeforeEach setup
 * - @Test annotations
 * - @DisplayName for readable test names
 * - Assertions (assertEquals, assertThrows)
 */
@DisplayName("Calculator Service Tests")
class CalculatorServiceTest {
    
    private CalculatorService calculatorService;
    
    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }
    
    @Test
    @DisplayName("Should add two positive numbers")
    void testAdd() {
        int result = calculatorService.add(5, 3);
        assertEquals(8, result);
    }
    
    @Test
    @DisplayName("Should subtract two numbers")
    void testSubtract() {
        int result = calculatorService.subtract(10, 4);
        assertEquals(6, result);
    }
    
    @Test
    @DisplayName("Should multiply two numbers")
    void testMultiply() {
        int result = calculatorService.multiply(4, 5);
        assertEquals(20, result);
    }
    
    @Test
    @DisplayName("Should divide two numbers")
    void testDivide() {
        double result = calculatorService.divide(10, 2);
        assertEquals(5.0, result, 0.001);
    }
    
    @Test
    @DisplayName("Should throw exception when dividing by zero")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(10, 0);
        });
    }
}
