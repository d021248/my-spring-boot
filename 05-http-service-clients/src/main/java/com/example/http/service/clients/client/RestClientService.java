package com.example.http.service.clients.client;

import com.example.http.service.clients.dto.PostDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * ⭐ ENHANCED IN SPRING BOOT 4.0: RestClient
 * 
 * RestClient is the new modern HTTP client in Spring Boot 4.0
 * It provides a fluent API and is easier to use than RestTemplate.
 */
@Component
public class RestClientService {
    
    private final RestClient restClient;
    
    public RestClientService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }
    
    public List<PostDTO> getAllPosts() {
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<PostDTO>>() {});
    }
    
    public PostDTO getPostById(Long id) {
        return restClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .body(PostDTO.class);
    }
    
    public PostDTO createPost(PostDTO post) {
        return restClient.post()
                .uri("/posts")
                .body(post)
                .retrieve()
                .body(PostDTO.class);
    }
}
