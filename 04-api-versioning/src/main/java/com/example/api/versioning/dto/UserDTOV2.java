package com.example.api.versioning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOV2 {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone; // New in V2
}
