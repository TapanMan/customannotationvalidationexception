package com.custom.validation.service;

import com.custom.validation.entity.MandalUser;
import com.custom.validation.repository.MandalUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class MandalUserDetailsServiceTest {

    @InjectMocks
    private MandalUserDetailsService service;

    @Mock
    private MandalUserRepository repository;

    @Test
    void loadUserByUsername() {
        String userName = "Tapan";
        MandalUser user = MandalUserDetailsServiceFactory.getMandalUser();
        given(repository.findByUserName(userName)).willReturn(user);
        UserDetails userDetails = service.loadUserByUsername(userName);
        assertNotNull(userDetails);
    }
}