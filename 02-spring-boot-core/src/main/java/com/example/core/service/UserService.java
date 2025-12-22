package com.example.core.service;

import com.example.core.dto.CreateUserRequest;
import com.example.core.dto.UserResponse;
import com.example.core.model.User;
import com.example.core.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Transactional
    public UserResponse createUser(CreateUserRequest request) {
        log.info("Creating user with email: {}", request.getEmail());
        
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists: " + request.getEmail());
        }
        
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        
        User savedUser = userRepository.save(user);
        log.info("User created with ID: {}", savedUser.getId());
        
        return mapToResponse(savedUser);
    }
    
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {
        log.info("Fetching user with ID: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
        return mapToResponse(user);
    }
    
    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();  // Java 16+ - simpler than Collectors.toList()
    }
    
    @Transactional(readOnly = true)
    public List<UserResponse> searchUsersByName(String name) {
        log.info("Searching users by name: {}", name);
        return userRepository.findByNameContainingIgnoreCase(name).stream()
                .map(this::mapToResponse)
                .toList();  // Java 16+ - simpler than Collectors.toList()
    }
    
    @Transactional
    public UserResponse updateUser(Long id, CreateUserRequest request) {
        log.info("Updating user with ID: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
        
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        
        User updatedUser = userRepository.save(user);
        log.info("User updated: {}", updatedUser.getId());
        
        return mapToResponse(updatedUser);
    }
    
    @Transactional
    public void deleteUser(Long id) {
        log.info("Deleting user with ID: {}", id);
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
        log.info("User deleted: {}", id);
    }
    
    private UserResponse mapToResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
