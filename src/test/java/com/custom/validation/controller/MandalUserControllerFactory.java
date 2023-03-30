package com.custom.validation.controller;

import com.custom.validation.dto.AuthRequest;

public class MandalUserControllerFactory {
    public static AuthRequest getAuthRequest() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setUsername("Tapan");
        authRequest.setPassword("pass1234");
        return authRequest;
    }
}
