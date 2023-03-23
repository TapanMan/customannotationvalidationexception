package com.custom.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This dto and it's component are for JWT only
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthRequest {
    private String username;
    private String password;

}
