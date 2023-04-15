package com.custom.validation.service;

import com.custom.validation.entity.User;

import java.util.Arrays;
import java.util.List;

public class UserPageSortServiceFactory {
    public static List<User> getUserList() {
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
