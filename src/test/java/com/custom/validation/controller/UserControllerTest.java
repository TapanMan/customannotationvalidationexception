package com.custom.validation.controller;

import com.custom.validation.dto.UserRequest;
import com.custom.validation.entity.User;
import com.custom.validation.exception.UserNotFoundByEmailException;
import com.custom.validation.exception.UserNotFoundException;
import com.custom.validation.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void getUser() throws UserNotFoundException {
        int userId = 1;
        User user = UserControllerFactory.getUser();
        given(service.searchUser(userId)).willReturn(user);
        ResponseEntity<User> response = controller.getUser(userId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    // TODO - Not Working
    /*
    @Test
    void getUserInvalid() throws UserNotFoundException {
        int userId = 0;
        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () ->{
            controller.getUser(userId);
        });
        assertEquals("User Not Found with id :" + userId, exception.getMessage());
    }
*/
    @Test
    void getUserById() throws UserNotFoundException {
        int userId = 1;
        User user = UserControllerFactory.getUser();
        given(service.searchUser(userId)).willReturn(user);
        ResponseEntity<User> response = controller.getUserById(userId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getUserByUserIdAndName() {
        int userId = 1;
        String username = "Tapan";
        User user = UserControllerFactory.getUser();
        given(service.getUserByUserIdAndName(userId, username)).willReturn(user);
        ResponseEntity<User> response = controller.getUserByUserIdAndName(userId, username);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getUserByUserIdAndNameJava8() {
        int userId = 1;
        String username = "Tapan";
        Optional<User> optionalUser = UserControllerFactory.getUserOptional();
        given(service.getUserByUserIdAndNameStream(userId, username)).willReturn(optionalUser);
        ResponseEntity<Optional<User>> response = controller.getUserByUserIdAndNameJava8(userId, username);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void sortingFields() {
        String filedName = "name";
        List<User> users = UserControllerFactory.getAllUsers();
        given(service.sortFields(filedName)).willReturn(users);
        ResponseEntity<List<User>> response = controller.sortingFields(filedName);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void userPagination() {
        int pageNumber = 1;
        int pageSize = 1;
        List<User> users = UserControllerFactory.getAllUsers();
        Page<User> page = new PageImpl<>(users);
        given(service.userPagination(pageNumber, pageSize)).willReturn(page);
        ResponseEntity<Page<User>> response = controller.userPagination(pageNumber, pageSize);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void userPaginationAndSorting() {
        int pageNumber = 1;
        int pageSize = 1;
        String fieldName = "name";
        List<User> users = UserControllerFactory.getAllUsers();
        Page<User> page = new PageImpl<>(users);
        given(service.userPaginationAndSorting(pageNumber, pageSize, fieldName)).willReturn(page);
        ResponseEntity<Page<User>> response = controller.userPaginationAndSorting(pageNumber, pageSize, fieldName);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void updateUser() {
        int userId = 1;
        User user = UserControllerFactory.getUser();
        given(service.updateUserDetails(userId, user)).willReturn(user);
        ResponseEntity<User> response = controller.updateUser(userId, user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void partiallyUpdateUser() {
        int userId = 1;
        Map<String, Object> fields = new HashMap<>();
        User user = UserControllerFactory.getUser();
        given(service.partiallyUpdateUser(userId, fields)).willReturn(user);
        ResponseEntity<User> response = controller.partiallyUpdateUser(userId, fields);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void updateUserNOId() {
        User user = UserControllerFactory.getUser();
        given(service.updateUserDetailsWithNoUserId(user)).willReturn(user);
        ResponseEntity<User> response = controller.updateUserNOId(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getUserByUserEmail() throws UserNotFoundByEmailException {
        String userEmail = "tapan.mandal@gamil.com";
        User user = UserControllerFactory.getUser();
        given(service.getUserByUserEmail(userEmail)).willReturn(user);
        ResponseEntity<User> response = controller.getUserByUserEmail(userEmail);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}