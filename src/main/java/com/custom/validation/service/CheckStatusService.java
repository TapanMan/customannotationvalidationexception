package com.custom.validation.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class CheckStatusService {
    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 7000))
    public String checkStatus() {
        System.out.println("Checking the Status whether my External URL is on or off !!");
        throw new RuntimeException("External URL is Off");
    }

    @Recover
    public String recover() {
        return "Please try when the External URL is on !!";
    }
}
