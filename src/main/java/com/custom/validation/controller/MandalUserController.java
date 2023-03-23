package com.custom.validation.controller;

import com.custom.validation.dto.AuthRequest;
import com.custom.validation.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller and it's component are for JWT only
 */
@RestController
public class MandalUserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/hello-guys")
    public String helloMandal() {
        return "Before Jwt Test";
    }

    @PostMapping("/generate-token")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception ex) {
            throw new Exception("Invalid Username or Password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}
