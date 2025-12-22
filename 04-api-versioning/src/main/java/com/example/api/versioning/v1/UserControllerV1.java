package com.example.api.versioning.v1;

import com.example.api.versioning.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * API Version 1 - User Controller
 * URL-based versioning: /api/v1/users
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserControllerV1 {
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        users.add(new UserDTO(1L, "John Doe", "john@example.com"));
        users.add(new UserDTO(2L, "Jane Smith", "jane@example.com"));
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = new UserDTO(id, "John Doe", "john@example.com");
        return ResponseEntity.ok(user);
    }
    
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        user.setId(System.currentTimeMillis());
        return ResponseEntity.ok(user);
    }
}
