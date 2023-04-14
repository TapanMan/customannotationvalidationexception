package com.custom.validation.service;

import com.custom.validation.entity.MandalUser;

public class MandalUserDetailsServiceFactory {
    public static MandalUser getMandalUser() {
        MandalUser user = new MandalUser();
        user.setId(28);
        user.setUserName("Tapan");
        user.setPassword("password1");
        user.setEmail("tapan.mandal@gmail.com");
        return user;
    }
}
