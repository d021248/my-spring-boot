package com.example.http.service.clients.controller;

import com.example.http.service.clients.client.RestClientService;
import com.example.http.service.clients.client.WebClientService;
import com.example.http.service.clients.dto.PostDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller to test HTTP clients interactively
 * 
 * Endpoints:
 * - GET  /api/posts              - Get all posts (RestClient)
 * - GET  /api/posts/{id}         - Get post by ID (RestClient)
 * - GET  /api/posts/reactive     - Get all posts (WebClient - reactive)
 * - GET  /api/posts/reactive/{id} - Get post by ID (WebClient - reactive)
 */
@RestController
@RequestMapping("/api/posts")
public class HttpClientController {
    
    private final RestClientService restClientService;
    private final WebClientService webClientService;
    
    public HttpClientController(RestClientService restClientService, 
                               WebClientService webClientService) {
        this.restClientService = restClientService;
        this.webClientService = webClientService;
    }
    
    @GetMapping
    public List<PostDTO> getAllPosts() {
        return restClientService.getAllPosts();
    }
    
    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        return restClientService.getPostById(id);
    }
    
    @GetMapping("/reactive")
    public List<PostDTO> getAllPostsReactive() {
        return webClientService.getAllPostsReactive().collectList().block();
    }
    
    @GetMapping("/reactive/{id}")
    public PostDTO getPostByIdReactive(@PathVariable Long id) {
        return webClientService.getPostByIdReactive(id).block();
    }
    
    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO post) {
        return restClientService.createPost(post);
    }
}
