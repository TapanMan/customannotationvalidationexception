package com.custom.validation.controller;

import com.custom.validation.dto.UserRequest;
import com.custom.validation.entity.User;
import com.custom.validation.exception.UserNotFoundException;
import com.custom.validation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<User> getUserById(@RequestParam (name = "userid") Integer id ) throws UserNotFoundException {
        return new ResponseEntity<>(service.getUser(id), HttpStatus.OK);
    }

    @GetMapping("/idandname")
    public ResponseEntity<User> getUserByUserIdAndName(@RequestParam (name = "userid") Integer id, @RequestParam (name = "username") String username) {
        return new ResponseEntity<>(service.getUserByUserIdAndName(id, username), HttpStatus.OK);
    }

    @GetMapping("/idandname8")
    public ResponseEntity<Optional<User>> getUserByUserIdAndNameJava8(@RequestParam (name = "userid") Integer id, @RequestParam (name = "username") String username) {
        return new ResponseEntity<>(service.getUserByUserIdAndNameStream(id, username), HttpStatus.OK);
    }
}
