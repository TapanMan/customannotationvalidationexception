package com.custom.validation.controller;

import com.custom.validation.dto.UserRequest;
import com.custom.validation.entity.User;

import java.util.Arrays;
import java.util.List;

public class UserControllerFactory {
    public static UserRequest getUserRequest() {
        UserRequest userRequest = new UserRequest();
        userRequest.setName("Tapan");
        userRequest.setEmail("tapan.tapan@gmail.com");
        userRequest.setMobile("1234567891");
        userRequest.setGender("Male");
        userRequest.setAge(45);
        userRequest.setNationality("India");
        return userRequest;
    }

    public static User getUser() {
        User user = new User();
        user.setUserId(1);
        user.setName("Tapan");
        user.setEmail("tapan.tapan@gmail.com");
        user.setMobile("1234567891");
        user.setGender("Male");
        user.setAge(45);
        user.setNationality("India");
        return user;
    }

    // TODO - Implement the builder pattern here
    public static List<User> getAllUsers() {
        User user1 = new User();
        user1.setUserId(1);
        user1.setName("Tapan");
        user1.setEmail("tapan.tapan@gmail.com");
        user1.setMobile("1234567891");
        user1.setGender("Male");
        user1.setAge(45);
        user1.setNationality("India");

        User user2 = new User();
        user2.setUserId(2);
        user2.setName("Dillip");
        user2.setEmail("dillip.tapan@gmail.com");
        user2.setMobile("2345678912");
        user2.setGender("Male");
        user2.setAge(41);
        user2.setNationality("India");

        List<User> users = Arrays.asList(user1, user2);
        return users;
    }
}
