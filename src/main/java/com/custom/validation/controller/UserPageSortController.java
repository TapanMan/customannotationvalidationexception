package com.custom.validation.controller;

import com.custom.validation.entity.User;
import com.custom.validation.service.UserPageSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserPageSortController {
    @Autowired
    private UserPageSortService userPageSortService;

    @GetMapping("/page-sort-repo")
    public ResponseEntity<List<User>> userPageSortAll(@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize, @RequestParam(name = "field", defaultValue = "name") String fieldName) {
        return new ResponseEntity<>(userPageSortService.pageSortAllUsers(pageNumber, pageSize, fieldName), HttpStatus.OK);
    }
}
