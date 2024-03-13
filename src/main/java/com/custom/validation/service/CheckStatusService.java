package com.custom.validation.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import com.custom.validation.util.MyTestUtil;
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

    public void methodRankPoints(double points) {
        if (points >= 60) {
            System.out.println("Rank:A1");
        } else if (points >= 50) {
            System.out.println("Rank:A2");
        } else {
            System.out.println("Rank:A3");
        }
    }

    public static int displayLine(int cubeNumber) {
        int outNumber = MyTestUtil.cubeOfNumber(cubeNumber);
        System.out.println("Cube of the Number is  = "+ outNumber);
        return outNumber;
    }
}
