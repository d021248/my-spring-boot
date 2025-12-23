#!/bin/bash

# Function to convert kebab-case to PascalCase
to_pascal_case() {
    echo "$1" | sed -r 's/(^|-)([a-z])/\U\2/g'
}

# Function to convert kebab-case to camelCase for package
to_camel_case() {
    echo "$1" | tr '-' ''
}

# Module data: num|artifact|name|description|port
modules=(
"13|advanced-jpa|Advanced JPA|Advanced JPA features: specifications, projections, entity graphs|8093"
"14|transaction-management|Transaction Management|Transaction propagation, isolation levels, rollback rules|8094"
"15|multiple-datasources|Multiple DataSources|Multi-tenancy and routing datasources|8095"
"16|spring-data-rest|Spring Data REST|Auto-exposed repositories with HATEOAS|8096"
"17|database-migrations|Database Migrations|Flyway and Liquibase integration|8097"
"18|nosql-databases|NoSQL Databases|MongoDB, Redis, Neo4j examples|8098"
"19|rabbitmq-messaging|RabbitMQ Messaging|Publisher/subscriber with RabbitMQ|8099"
"20|kafka-integration|Kafka Integration|Producers, consumers, and streams|8100"
"21|websocket-communication|WebSocket Communication|Real-time bidirectional communication|8101"
"22|spring-integration|Spring Integration|Enterprise Integration Patterns|8102"
"23|spring-security-basics|Spring Security Basics|Authentication and authorization|8103"
"24|oauth2-keycloak|OAuth2 Keycloak|OAuth2 flows, JWT tokens, SSO|8104"
"25|ldap-authentication|LDAP Authentication|LDAP integration|8105"
"26|actuator-monitoring|Actuator Monitoring|Health checks, metrics, custom endpoints|8106"
"27|logging-strategies|Logging Strategies|Logback, log levels, MDC, structured logging|8107"
"28|error-handling|Error Handling|Global exception handling, Problem Details|8108"
"29|validation-advanced|Advanced Validation|Custom validators, validation groups|8109"
"30|content-negotiation|Content Negotiation|Multiple response formats (JSON/XML)|8110"
"31|file-upload-download|File Upload Download|Multipart requests, streaming|8111"
"32|graphql-api|GraphQL API|Schema definition, resolvers, subscriptions|8112"
"33|hateoas|HATEOAS|Hypermedia-driven APIs|8113"
"34|api-documentation|API Documentation|OpenAPI/Swagger, Springdoc|8114"
"35|cors-configuration|CORS Configuration|Cross-origin resource sharing|8115"
"36|docker-containerization|Docker Containerization|Dockerfile, layered jars, buildpacks|8116"
"37|kubernetes-deployment|Kubernetes Deployment|K8s manifests, health probes|8117"
"38|spring-boot-admin|Spring Boot Admin|Admin server/client setup|8118"
"39|distributed-tracing|Distributed Tracing|Zipkin, Jaeger integration|8119"
"40|custom-starter|Custom Starter|Creating auto-configuration starters|8120"
"41|aop-aspects|AOP Aspects|Cross-cutting concerns, pointcuts|8121"
"42|batch-processing|Batch Processing|Job configuration, chunks, listeners|8122"
"43|reactive-webflux|Reactive WebFlux|Mono/Flux, reactive repositories|8123"
"44|graalvm-native|GraalVM Native|Native image compilation, AOT|8124"
"45|thymeleaf-templates|Thymeleaf Templates|Server-side rendering|8125"
"46|form-validation|Form Validation|Form binding, validation messages|8126"
"47|soap-webservices|SOAP WebServices|WSDL, JAXB, service endpoints|8127"
"48|jasypt-encryption|Jasypt Encryption|Configuration encryption|8128"
"49|resilience-patterns|Resilience Patterns|Circuit breaker, retry, bulkhead|8129"
"50|event-driven-architecture|Event Driven Architecture|Domain events, event sourcing|8130"
"51|caching-strategies|Caching Strategies|Spring Cache, Redis, Caffeine|8131"
"52|rate-limiting|Rate Limiting|Bucket4j, API throttling|8132"
"53|multitenancy|Multitenancy|Tenant isolation strategies|8133"
"54|audit-logging|Audit Logging|Track changes, who did what when|8134"
"55|internationalization|Internationalization|i18n, message bundles|8135"
"56|spring-cloud-config|Spring Cloud Config|Centralized configuration|8136"
"57|service-discovery|Service Discovery|Eureka, Consul integration|8137"
"58|circuit-breaker|Circuit Breaker|Resilience4j patterns|8138"
"59|distributed-locking|Distributed Locking|ShedLock, distributed coordination|8139"
)

for module_def in "${modules[@]}"; do
    IFS='|' read -r num artifact name description port <<< "$module_def"
    module_dir="${num}-${artifact}"
    
    # Convert names
    package_name=$(to_camel_case "$artifact")
    class_name=$(to_pascal_case "$artifact")
    
    # Remove old incorrect file
    rm -f "${module_dir}/src/main/java/com/example/${artifact//-/}/${class_name}App.java"
    rm -f "${module_dir}/src/main/java/com/example/${class_name}App.java"
    
    # Create correct directory
    mkdir -p "${module_dir}/src/main/java/com/example/${package_name}"
    
    # Create corrected Java file
    cat > "${module_dir}/src/main/java/com/example/${package_name}/${class_name}Application.java" << JAVA_EOF
package com.example.${package_name};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ${name} Demo Application
 * 
 * ${description}
 * 
 * Port: ${port}
 * Landing Page: http://localhost:${port}
 */
@SpringBootApplication
public class ${class_name}Application {

    public static void main(String[] args) {
        SpringApplication.run(${class_name}Application.class, args);
    }
}
JAVA_EOF

    echo "✅ Fixed module ${num}: ${name}"
done

echo ""
echo "🎉 All Java files fixed!"
