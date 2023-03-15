package com.custom.validation.controller;

import com.custom.validation.dto.UserRequest;
import com.custom.validation.entity.User;
import com.custom.validation.exception.UserNotFoundException;
import com.custom.validation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }

    @GetMapping("/userid")
    public ResponseEntity<User> getUserById(@RequestParam(name = "userid") Integer id) throws UserNotFoundException {
        return new ResponseEntity<>(service.getUser(id), HttpStatus.OK);
    }

    @GetMapping("/idandname")
    public ResponseEntity<User> getUserByUserIdAndName(@RequestParam(name = "userid") Integer id, @RequestParam(name = "username") String username) {
        return new ResponseEntity<>(service.getUserByUserIdAndName(id, username), HttpStatus.OK);
    }

    @GetMapping("/idandname8")
    public ResponseEntity<Optional<User>> getUserByUserIdAndNameJava8(@RequestParam(name = "userid") Integer id, @RequestParam(name = "username") String username) {
        return new ResponseEntity<>(service.getUserByUserIdAndNameStream(id, username), HttpStatus.OK);
    }

    @GetMapping("/sorting")
    public ResponseEntity<List<User>> sortingFields(@RequestParam(name = "fieldName") String filedName) {
        return new ResponseEntity<>(service.sortFields(filedName), HttpStatus.OK);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<User>> userPagination(@RequestParam(name = "pageNum") Integer pageNumber, @RequestParam(name = "pageSize") Integer pageSize) {
        return new ResponseEntity<>(service.userPagination(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/paginationsorting")
    public ResponseEntity<Page<User>> userPaginationAndSorting(@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize, @RequestParam(name = "fieldName", defaultValue = "name") String fieldName) {
        return new ResponseEntity<>(service.userPaginationAndSorting(pageNumber, pageSize, fieldName), HttpStatus.OK);
    }

    // Check the  service class for this updateUser() method
    @PutMapping("/{uid}")
    public ResponseEntity<User> updateUser(@PathVariable int uid, @RequestBody User user) {
        return new ResponseEntity<>(service.updateUserDetails(uid, user), HttpStatus.OK);
    }
}
