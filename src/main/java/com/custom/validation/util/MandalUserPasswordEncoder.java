package com.custom.validation.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class and it's component are for JWT only
 */
public class MandalUserPasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("pass101");
        System.out.println("The encoded password  :" + encodedPassword);
    }
}
