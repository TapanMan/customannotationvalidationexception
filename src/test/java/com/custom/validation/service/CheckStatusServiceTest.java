package com.custom.validation.service;

import com.custom.validation.util.MyTestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class CheckStatusServiceTest {

    @InjectMocks
    CheckStatusService checkStatusService;

    @Test
    void checkStatus() {
    }

    @Test
    void recover() {
    }

    @Test
    void methodRankPoints() {
    }

    @Test
    void displayLine() {
        //Mock the static method of the util class, there could be non-static method as well
        //But the procedure will same
        int number = 95;
        //Below two lines are compulsory
        Mockito.mockStatic(MyTestUtil.class);
        Mockito.when(MyTestUtil.cubeOfNumber(number)).thenReturn(number);
        // When
        int numberFound = checkStatusService.displayLine(number);
        // Then
        assertTrue(numberFound > 90);
    }
}