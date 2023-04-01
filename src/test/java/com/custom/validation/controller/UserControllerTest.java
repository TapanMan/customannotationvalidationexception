package com.custom.validation.controller;

import com.custom.validation.dto.UserRequest;
import com.custom.validation.entity.User;
import com.custom.validation.service.UserService;
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
class UserControllerTest {

    @InjectMocks
    UserController controller;

    @Mock
    UserService service;

    @Test
    void saveUser() {
        UserRequest request = UserControllerFactory.getUserRequest();
        User user = UserControllerFactory.getUser();
        given(service.saveUser(request)).willReturn(user);
        ResponseEntity<User> response = controller.saveUser(request);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void getAll() {
        List<User> users = UserControllerFactory.getAllUsers();
        given(service.getAllUsers()).willReturn(users);
        ResponseEntity<List<User>> response = controller.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void getUserByUserIdAndName() {
    }

    @Test
    void getUserByUserIdAndNameJava8() {
    }

    @Test
    void sortingFields() {
    }

    @Test
    void userPagination() {
    }

    @Test
    void userPaginationAndSorting() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void partiallyUpdateUser() {
    }

    @Test
    void updateUserNOId() {
    }

    @Test
    void getUserByUserEmail() {
    }
}