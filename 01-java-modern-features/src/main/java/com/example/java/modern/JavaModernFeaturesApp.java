package com.example.java.modern;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Java Modern Features Demonstration
 * 
 * Demonstrates Java 21+ features:
 * - Records
 * - Pattern Matching
 * - Sealed Classes
 * - Virtual Threads
 * - Text Blocks
 * - Switch Expressions
 */
@SpringBootApplication
public class JavaModernFeaturesApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaModernFeaturesApp.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("\n=== Java Modern Features Demo ===\n");
        
        demonstrateRecords();
        demonstratePatternMatching();
        demonstrateSealedClasses();
        demonstrateTextBlocks();
        demonstrateSwitchExpressions();
        demonstrateVirtualThreads();
    }

    // RECORDS - Compact data carriers
    record Person(String name, int age, String email) {
        // Compact constructor
        public Person {
            if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        }
        
        // Additional methods
        public boolean isAdult() {
            return age >= 18;
        }
    }

    private void demonstrateRecords() {
        System.out.println("1. Records Demo:");
        Person person = new Person("Alice", 30, "alice@example.com");
        System.out.println("   Person: " + person);
        System.out.println("   Is adult? " + person.isAdult());
        System.out.println();
    }

    // PATTERN MATCHING
    private void demonstratePatternMatching() {
        System.out.println("2. Pattern Matching Demo:");
        
        Object obj = "Hello World";
        
        // Pattern matching for instanceof
        if (obj instanceof String s) {
            System.out.println("   String length: " + s.length());
        }
        
        // Pattern matching in switch
        String result = switch (obj) {
            case String s -> "String: " + s;
            case Integer i -> "Integer: " + i;
            case null -> "null";
            default -> "Unknown type";
        };
        System.out.println("   Result: " + result);
        System.out.println();
    }

    // SEALED CLASSES - Restricted class hierarchies
    sealed interface Shape permits Circle, Rectangle {
        double area();
    }

    record Circle(double radius) implements Shape {
        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    record Rectangle(double width, double height) implements Shape {
        @Override
        public double area() {
            return width * height;
        }
    }

    private void demonstrateSealedClasses() {
        System.out.println("3. Sealed Classes Demo:");
        
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        
        // Exhaustive switch with sealed types
        System.out.println("   Circle area: " + calculateArea(circle));
        System.out.println("   Rectangle area: " + calculateArea(rectangle));
        System.out.println();
    }

    private double calculateArea(Shape shape) {
        return switch (shape) {
            case Circle c -> c.area();
            case Rectangle r -> r.area();
        };
    }

    // TEXT BLOCKS - Multiline strings
    private void demonstrateTextBlocks() {
        System.out.println("4. Text Blocks Demo:");
        
        String json = """
                {
                    "name": "John",
                    "age": 30,
                    "city": "New York"
                }
                """;
        
        System.out.println("   JSON:\n" + json);
    }

    // SWITCH EXPRESSIONS
    private void demonstrateSwitchExpressions() {
        System.out.println("5. Switch Expressions Demo:");
        
        String day = "MONDAY";
        int numLetters = switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
            case "TUESDAY" -> 7;
            case "THURSDAY", "SATURDAY" -> 8;
            case "WEDNESDAY" -> 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
        
        System.out.println("   " + day + " has " + numLetters + " letters");
        System.out.println();
    }

    // VIRTUAL THREADS - Lightweight concurrency
    private void demonstrateVirtualThreads() {
        System.out.println("6. Virtual Threads Demo:");
        
        try {
            // Create virtual thread
            Thread vThread = Thread.ofVirtual().start(() -> {
                System.out.println("   Running in virtual thread: " + 
                                   Thread.currentThread().getName());
            });
            
            vThread.join();
            
            // Virtual threads executor
            System.out.println("   Virtual threads are perfect for I/O-bound tasks!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println();
    }
}
