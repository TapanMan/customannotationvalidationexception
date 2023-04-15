package com.custom.validation.service;

import com.custom.validation.entity.User;
import com.custom.validation.repository.UserPageSortRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserPageSortServiceTest {

    @InjectMocks
    private UserPageSortService service;

    @Mock
    private UserPageSortRepository repository;

    @Test
    void pageSortAllUsers() {
        Integer pageNumber = 2;
        Integer pageSize = 2;
        String field = "userName";
        List<User> users = UserPageSortServiceFactory.getUserList();
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(field));
        Page<User> page = new PageImpl<>(new ArrayList<>(users));
        given(repository.findAll(paging)).willReturn(page);
        List<User> result = service.pageSortAllUsers(pageNumber, pageSize, field);
        assertNotNull(result);
        assertTrue(page.hasContent());
        assertEquals(page.getContent(), users);
    }

    @Test
    void pageSortAllUsersInvalid() {
        List<User> users = Collections.emptyList();
        ArrayList<User> userList = new ArrayList<>();
        Page<User> page = new PageImpl<>(users);
        assertFalse(page.hasContent());
        assertEquals(page.getContent(), userList);
    }
}