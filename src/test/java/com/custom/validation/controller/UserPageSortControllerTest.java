package com.custom.validation.controller;

import com.custom.validation.entity.User;
import com.custom.validation.service.UserPageSortService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class UserPageSortControllerTest {

    @InjectMocks
    UserPageSortController pageSortController;

    @Mock
    UserPageSortService userPageSortService;

    @Test
    void userPageSortAll() {
        int pageNumber = 1;
        int pageSize = 1;
        String fieldName ="name";
        List<User> users = UserPageSortControllerFactory.getAllUsersForUserPageSort();
        given(userPageSortService.pageSortAllUsers(pageNumber, pageSize, fieldName)).willReturn(users);
        ResponseEntity<List<User>> response = pageSortController.userPageSortAll(pageNumber, pageSize,fieldName);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
}