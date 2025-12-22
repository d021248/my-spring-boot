package com.example.http.service.clients.client;

import com.example.http.service.clients.dto.PostDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * WebClient for Reactive HTTP Calls
 * Enhanced in Spring Boot 4.0 with better error handling and resilience
 */
@Component
public class WebClientService {
    
    private final WebClient webClient;
    
    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }
    
    public Flux<PostDTO> getAllPostsReactive() {
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(PostDTO.class);
    }
    
    public Mono<PostDTO> getPostByIdReactive(Long id) {
        return webClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .bodyToMono(PostDTO.class);
    }
}
