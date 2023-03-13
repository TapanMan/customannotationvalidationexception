package com.custom.validation.service;

import com.custom.validation.dto.UserRequest;
import com.custom.validation.entity.User;
import com.custom.validation.exception.UserNotFoundException;
import com.custom.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
