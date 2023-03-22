package com.custom.validation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller and it's component are for JWT only
 */
@RestController
public class MandalUserController {

    @GetMapping("/hello-guys")
    public String helloMandal() {
        return "Before Jwt Test";
    }
}
