package com.custom.validation.controller;

import com.custom.validation.service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckStatusController {
    @Autowired
    private CheckStatusService checkStatusService;

    @GetMapping("/check-status")
    public String checkExternalSystemStatus() {
        return checkStatusService.checkStatus();
    }
}
