# Spring Boot 4.0 Quick Start Guide 🚀

Get started with Spring Boot 4.0 in minutes!

## Prerequisites

- **Java 21+** (JDK 21 or higher)
- **Maven 3.8+**
- IDE: IntelliJ IDEA, VS Code, or Eclipse

## Build & Run

### Build All Modules
```bash
mvn clean install
```

### Run Individual Modules

#### Module 1: Java Modern Features
```bash
cd 01-java-modern-features
mvn spring-boot:run
```
**What you'll see:** Demonstrations of Java 21+ features including Records, Pattern Matching, Sealed Classes, Virtual Threads, Text Blocks, and Switch Expressions.

#### Module 2: Spring Boot Core
```bash
cd 02-spring-boot-core
mvn spring-boot:run
```
**Endpoints:**
- Health: `http://localhost:8080/actuator/health`
- REST API examples at `http://localhost:8080/api/...`

#### Module 3: Spring Boot Advanced
```bash
cd 03-spring-boot-advanced
mvn spring-boot:run
```
**Features:** Security, Caching, Async Processing, Events, WebFlux

#### Module 4: API Versioning ⭐ NEW IN 4.0
```bash
cd 04-api-versioning
mvn spring-boot:run
```
**Try it:**
- V1 API: `http://localhost:8080/api/v1/users`
- V2 API: `http://localhost:8080/api/v2/users`

#### Module 5: HTTP Service Clients ⭐ ENHANCED IN 4.0
```bash
cd 05-http-service-clients
mvn spring-boot:run
```
**Features:** RestClient, WebClient, Declarative HTTP Interfaces

#### Module 6: Observability
```bash
cd 06-observability
mvn spring-boot:run
```
**Actuator Endpoints:**
- Health: `http://localhost:8080/actuator/health`
- Metrics: `http://localhost:8080/actuator/metrics`
- Info: `http://localhost:8080/actuator/info`

#### Module 7: Design Patterns
```bash
cd 07-design-patterns
mvn spring-boot:run
```
**Patterns:** Factory, Strategy, Observer, Decorator with Spring

#### Module 8: Testing Strategies
```bash
cd 08-testing-strategies
mvn test
```
**Includes:** Unit tests, Integration tests, Testcontainers

#### Module 9: Best Practices ⭐ ENHANCED WITH JSPECIFY
```bash
cd 09-best-practices
mvn spring-boot:run
```
**Features:** Null Safety (JSpecify), Exception Handling, Validation, Logging

## What's New in Spring Boot 4.0?

### 1. **Modular Architecture**
Spring Boot 4.0 has been completely modularized for smaller, more focused dependencies:
```xml
<!-- Instead of large monolithic jars -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### 2. **Null Safety with JSpecify**
Improved null safety across the entire Spring portfolio:
```java
import org.jspecify.annotations.Nullable;
import org.jspecify.annotations.NonNull;

public @NonNull String process(@Nullable String input) {
    return input != null ? input : "default";
}
```

### 3. **API Versioning**
Built-in support for API versioning:
```java
@RestController
@RequestMapping("/api/v1/users")
public class UserControllerV1 { }

@RestController
@RequestMapping("/api/v2/users")
public class UserControllerV2 { }
```

### 4. **Enhanced HTTP Service Clients**
Declarative HTTP clients with improved error handling:
```java
@HttpExchange("/api/users")
public interface UserClient {
    @GetExchange("/{id}")
    User getUser(@PathVariable Long id);
}
```

### 5. **Java 25 Support**
Full support for Java 25 while maintaining Java 17+ compatibility.

### 6. **Spring Framework 7**
Built on Spring Framework 7 with all its improvements and new features.

## Learning Resources

- **Spring Boot 4.0 Release Notes**: https://spring.io/blog/2025/11/20/spring-boot-4-0-0-available-now
- **Migration Guide**: https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-4.0-Migration-Guide
- **Spring Framework 7 Docs**: https://docs.spring.io/spring-framework/reference/
- **Java 21 Features**: https://docs.oracle.com/en/java/javase/21/

## Common Commands

```bash
# Build without tests
mvn clean install -DskipTests

# Run with specific profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Package as JAR
mvn package

# Run JAR
java -jar target/*.jar

# Debug mode
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
```

## Project Structure

```
spring-boot-educational/
├── 01-java-modern-features/     # Java 21+ features
├── 02-spring-boot-core/         # Core Spring Boot
├── 03-spring-boot-advanced/     # Advanced features
├── 04-api-versioning/           # API versioning (NEW)
├── 05-http-service-clients/     # HTTP clients (ENHANCED)
├── 06-observability/            # Monitoring & metrics
├── 07-design-patterns/          # Design patterns
├── 08-testing-strategies/       # Testing approaches
└── 09-best-practices/           # Production practices
```

## Next Steps

1. ✅ **Build the project**: `mvn clean install`
2. ✅ **Explore a module**: Choose one and run it
3. ✅ **Read the code**: Each file has detailed comments
4. ✅ **Experiment**: Modify and run to see changes
5. ✅ **Learn**: Follow the recommended learning path in README.md

## Need Help?

- Check the main [README.md](README.md) for detailed documentation
- Each module has its own README with specific instructions
- Look at the code comments for explanations
- Review the Spring Boot 4.0 official documentation

---

**Happy coding with Spring Boot 4.0! 🎉**
