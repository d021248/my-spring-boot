package com.example.fileuploaddownload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * File Upload Download Demo Application
 * 
 * Multipart requests, streaming
 * 
 * Port: 8111
 * Landing Page: http://localhost:8111
 */
@SpringBootApplication
public class FileUploadDownloadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadDownloadApplication.class, args);
    }
}
