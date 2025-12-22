package com.example.api.versioning.v2;

import com.example.api.versioning.dto.UserDTOV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * API Version 2 - User Controller (Enhanced)
 * URL-based versioning: /api/v2/users
 * 
 * Changes from V1:
 * - Split name into firstName/lastName
 * - Added phone field
 * - Enhanced response structure
 */
@RestController
@RequestMapping("/api/v2/users")
public class UserControllerV2 {
    
    @GetMapping
    public ResponseEntity<List<UserDTOV2>> getAllUsers() {
        List<UserDTOV2> users = new ArrayList<>();
        users.add(new UserDTOV2(1L, "John", "Doe", "john@example.com", "+1234567890"));
        users.add(new UserDTOV2(2L, "Jane", "Smith", "jane@example.com", "+0987654321"));
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDTOV2> getUserById(@PathVariable Long id) {
        UserDTOV2 user = new UserDTOV2(id, "John", "Doe", "john@example.com", "+1234567890");
        return ResponseEntity.ok(user);
    }
    
    @PostMapping
    public ResponseEntity<UserDTOV2> createUser(@RequestBody UserDTOV2 user) {
        user.setId(System.currentTimeMillis());
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<UserDTOV2>> searchUsers(@RequestParam String query) {
        List<UserDTOV2> users = new ArrayList<>();
        users.add(new UserDTOV2(1L, "John", "Doe", "john@example.com", "+1234567890"));
        return ResponseEntity.ok(users);
    }
}
