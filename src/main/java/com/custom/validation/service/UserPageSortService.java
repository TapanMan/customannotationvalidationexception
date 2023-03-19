package com.custom.validation.service;

import com.custom.validation.entity.User;
import com.custom.validation.repository.UserPageSortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserPageSortService {
    @Autowired
    private UserPageSortRepository userPageSortRepository;

    public List<User> pageSortAllUsers(Integer pageNumber, Integer pageSize, String fieldName) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(fieldName));
        Page<User> pageResult = userPageSortRepository.findAll(paging);
        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<User>();
        }
    }
}
