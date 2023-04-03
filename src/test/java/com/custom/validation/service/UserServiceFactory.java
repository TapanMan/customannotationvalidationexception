package com.custom.validation.service;

import com.custom.validation.dto.UserRequest;
import com.custom.validation.entity.User;

import java.util.Arrays;
import java.util.List;

public class UserServiceFactory {
    public static User getUser(){
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

    public static List<User> getUserList(){
        User user = new User();
        user.setUserId(1);
        user.setName("Tapan");
        user.setEmail("tapan.tapan@gmail.com");
        user.setMobile("1234567891");
        user.setGender("Male");
        user.setAge(45);
        user.setNationality("India");

        User user2 = new User();
        user2.setUserId(2);
        user2.setName("Dillip");
        user2.setEmail("dillip.dillip@gmail.com");
        user2.setMobile("2345678912");
        user2.setGender("Male");
        user2.setAge(41);
        user2.setNationality("India");
        List<User> userList = Arrays.asList(user, user2);

        return userList;
    }
}
