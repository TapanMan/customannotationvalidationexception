package com.custom.validation.service;

import com.custom.validation.dto.UserRequest;
import com.custom.validation.entity.User;
import com.custom.validation.exception.UserNotFoundException;
import com.custom.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest request) {
        User user = User.build(0, request.getName(), request.getEmail(), request.getMobile(), request.getGender(), request.getAge(), request.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);

        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User Not Found with id :" + id);
        }
    }

    public User getUserByUserIdAndName(Integer id, String name) {
        List<User> users = userRepository.findAll();
        User user = null;
        for (User u : users) {
            if (u.getUserId() == id && u.getName().equalsIgnoreCase(name)) {
                user = u;
                break;
            }
        }
        return user;
    }

    public Optional<User> getUserByUserIdAndNameStream(Integer id, String name) {
        List<User> users = userRepository.findAll();
        Optional<User> filterUser = users.stream().filter(user -> user.getUserId() == id && user.getName().equalsIgnoreCase(name)).findAny();
        return filterUser;
    }

    public List<User> sortFields(String filed) {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, filed));
    }

    public Page<User> userPagination(int offset, int pageSize) {
        Page<User> users = userRepository.findAll(PageRequest.of(offset, pageSize));
        return users;
    }

    public Page<User> userPaginationAndSorting(int offset, int pageSize, String filedName) {
        Page<User> users = userRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(filedName)));
        return users;
    }

    public User updateUserDetails(int id, User user) {
        User updatedUser = userRepository.findByUserId(id);
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setMobile(user.getMobile());
        updatedUser.setGender(user.getGender());
        updatedUser.setAge(user.getAge());
        updatedUser.setNationality(user.getNationality());
        return userRepository.save(updatedUser);
    }
}
