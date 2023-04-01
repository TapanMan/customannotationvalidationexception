package com.custom.validation.controller;

import com.custom.validation.dto.AuthRequest;
import com.custom.validation.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)

public class MandalUserControllerTest {

    @InjectMocks
    MandalUserController userController;

    @Mock
    AuthenticationManager manager;

    @Mock
    Authentication authentication;

    @Mock
    JwtUtil jwtUtil;

    @InjectMocks
    private UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("Tapan", "pass1234");

    @Test
    public void helloMandal() {
        String expected = "Before Jwt Test";
        String actual = userController.helloMandal();
        assertEquals(expected, actual);
    }

    @Test
    public void generateToken() throws Exception {
        String resultantToken = "";
        AuthRequest authRequest = MandalUserControllerFactory.getAuthRequest();
        given(manager.authenticate(token)).willReturn(authentication);
        given(jwtUtil.generateToken(authRequest.getUsername())).willReturn(resultantToken);
        String testToken = userController.generateToken(authRequest);
        assertNotNull(testToken);
    }

    @Test
    public void generateTokenInvalid() throws Exception {
        Throwable exception = assertThrows(Exception.class, () -> {
            userController.generateToken(null);
        });
        assertEquals("Invalid Username or Password", exception.getMessage());
    }
}
