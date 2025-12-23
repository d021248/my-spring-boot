package com.example.soapwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SOAP WebServices Demo Application
 * 
 * WSDL, JAXB, service endpoints
 * 
 * Port: 8127
 * Landing Page: http://localhost:8127
 */
@SpringBootApplication
public class SoapWebservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapWebservicesApplication.class, args);
    }
}
