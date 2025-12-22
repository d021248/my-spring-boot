# Spring Boot 4.0 Educational Project 🚀

A comprehensive educational project showcasing **Spring Boot 4.0**, **Spring Framework 7**, and **Java 21+** modern features and best practices.

## 🌟 What's New in Spring Boot 4.0

This project demonstrates the latest features introduced in Spring Boot 4.0:
- **Complete Modularization** - Smaller, more focused Spring Boot jars
- **Improved Null Safety** with JSpecify annotations
- **Java 25 Support** (while maintaining Java 17+ compatibility)  
- **API Versioning** for RESTful services
- **HTTP Service Clients** enhancements
- **Spring Framework 7** integration

## 📚 Project Modules

### 1. **Java Modern Features** (`01-java-modern-features`)
Demonstrates modern Java features:
- Java 21 LTS: Records, Pattern Matching, Sealed Classes, Virtual Threads
- Text Blocks, Switch Expressions
- SequencedCollections and modern APIs

### 2. **Spring Boot Core** (`02-spring-boot-core`)
Essential Spring Boot concepts:
- Dependency Injection & IoC Container
- REST APIs with Spring MVC
- Spring Data JPA with H2
- Configuration management
- Application properties and profiles

### 3. **Spring Boot Advanced** (`03-spring-boot-advanced`)
Advanced Spring Boot features:
- Spring Security with JWT
- Caching strategies (Caffeine)
- Async processing & `@Async`
- Event-driven architecture
- WebFlux reactive programming

### 4. **API Versioning** (`04-api-versioning`) ⭐ NEW
Spring Boot 4.0's new API versioning capabilities:
- URL-based versioning
- Header-based versioning
- Content negotiation versioning
- Deprecation strategies

### 5. **HTTP Service Clients** (`05-http-service-clients`) ⭐ NEW
Enhanced HTTP client features:
- Declarative HTTP interfaces
- RestClient improvements
- WebClient advanced usage
- Error handling and retries
- Circuit breaker patterns

### 6. **Observability** (`06-observability`)
Production-ready monitoring:
- Spring Boot Actuator endpoints
- Micrometer metrics
- Distributed tracing with Micrometer Tracing
- Custom health indicators
- Prometheus & Grafana integration

### 7. **Design Patterns** (`07-design-patterns`)
Common design patterns with Spring:
- Factory, Strategy, Observer, Decorator
- Singleton, Prototype, Builder
- Template Method, Chain of Responsibility
- Spring-specific patterns

### 8. **Testing Strategies** (`08-testing-strategies`)
Comprehensive testing approaches:
- Unit testing with JUnit 5 & Mockito
- Integration testing with `@SpringBootTest`
- Testcontainers for database testing
- REST API testing with MockMvc
- Performance testing basics

### 9. **Best Practices** (`09-best-practices`) ⭐ ENHANCED
Production-ready code practices:
- **Null Safety** with JSpecify (Spring Boot 4.0)
- Exception handling & global error handlers
- Validation with Jakarta Bean Validation
- Logging strategies (SLF4J)
- API documentation with SpringDoc OpenAPI
- Security best practices

## 🚀 Quick Start

### Prerequisites
- **Java 21+** (JDK 21 or higher)
- **Maven 3.8+**
- Your favorite IDE (IntelliJ IDEA, VS Code, Eclipse)

### Build the Project
```bash
mvn clean install
```

### Run Individual Modules
Each module is a standalone Spring Boot application:

```bash
# Core features
cd 02-spring-boot-core
mvn spring-boot:run

# API Versioning examples
cd 04-api-versioning
mvn spring-boot:run

# HTTP Service Clients
cd 05-http-service-clients
mvn spring-boot:run
```

## 📖 Learning Path

**Recommended order for beginners:**
1. Java Modern Features → Learn the latest Java capabilities
2. Spring Boot Core → Understand the fundamentals
3. Spring Boot Advanced → Master advanced techniques
4. API Versioning → Learn modern API design
5. HTTP Service Clients → Master client-side communication
6. Observability → Production monitoring
7. Testing Strategies → Quality assurance
8. Design Patterns → Proven solutions
9. Best Practices → Production-ready code

## 🔥 Key Features Demonstrated

### Spring Boot 4.0 Highlights
- ✅ Modular Spring Boot dependencies
- ✅ JSpecify null safety annotations
- ✅ API versioning with `@ApiVersion`
- ✅ Enhanced HTTP Service Clients
- ✅ Spring Framework 7 features

### Modern Java Features
- ✅ Records for data carriers
- ✅ Pattern matching for `instanceof`
- ✅ Sealed classes for restricted hierarchies
- ✅ Virtual threads for lightweight concurrency
- ✅ Text blocks for multiline strings
- ✅ Switch expressions

### Production-Ready Features
- ✅ Comprehensive security with Spring Security
- ✅ Caching with Caffeine
- ✅ Async processing
- ✅ Event-driven architecture
- ✅ Actuator for monitoring
- ✅ Distributed tracing
- ✅ Testcontainers for integration testing

## 🛠️ Technology Stack

| Category | Technology |
|----------|-----------|
| **Framework** | Spring Boot 4.0.0, Spring Framework 7 |
| **Java** | Java 21 LTS (compatible with Java 17+) |
| **Build Tool** | Maven 3.8+ |
| **Database** | H2 (in-memory), Spring Data JPA |
| **Security** | Spring Security, JWT |
| **Caching** | Caffeine |
| **Observability** | Actuator, Micrometer, Prometheus |
| **Testing** | JUnit 5, Mockito, Testcontainers |
| **API Docs** | SpringDoc OpenAPI 3.0 |
| **Null Safety** | JSpecify |

## 📝 Module Details

Each module contains:
- **Comprehensive examples** with detailed comments
- **README.md** explaining concepts and usage
- **Runnable Spring Boot applications**
- **Unit and integration tests**
- **Best practices** and anti-patterns to avoid

## 🤝 Contributing

This is an educational project. Feel free to:
- Report issues or suggest improvements
- Add new examples or modules
- Improve documentation
- Share your learning experience

## 📚 Resources

- [Spring Boot 4.0 Release Notes](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-4.0-Release-Notes)
- [Spring Framework 7 Documentation](https://docs.spring.io/spring-framework/reference/)
- [Spring Boot 4.0 Migration Guide](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-4.0-Migration-Guide)
- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)

## 📄 License

This project is created for educational purposes.

---

**Built with ❤️ using Spring Boot 4.0 and Java 21**
