package com.custom.validation.controller;

import com.custom.validation.service.CheckStatusService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class CheckStatusControllerTest {
    @InjectMocks
    CheckStatusController checkStatusController;

    @Mock
    CheckStatusService checkStatusService;

    @Test
    void checkExternalSystemStatus() {
    }

    @Test
    void methodRankPointsDetails() {
        double point = 67.0;
        // When [Here the last part is calling first - Invoke First]
        // Here doNothing() is not required
        checkStatusController.methodRankPointsDetails(point);
        //Then [call the First part - It is inside the above invoke]
        verify(checkStatusService, times(1)).methodRankPoints(point);
    }
}