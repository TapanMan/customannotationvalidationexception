package com.custom.validation.service;

import com.custom.validation.dto.UserRequest;
import com.custom.validation.entity.User;
import com.custom.validation.exception.UserNotFoundByEmailException;
import com.custom.validation.exception.UserNotFoundException;
import com.custom.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = Logger.getLogger(UserService.class.getName());

    public User saveUser(UserRequest request) {
        User user = User.build(0, request.getName(), request.getEmail(), request.getMobile(), request.getGender(), request.getAge(), request.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        logger.info("Calling the database and fetching the User Records");
        return userRepository.findAll();
    }

    public User searchUser(int id) throws UserNotFoundException {
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

    public User partiallyUpdateUser(int uid, Map<String, Object> fields) {
        User updatedUser = userRepository.findByUserId(uid);
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(User.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, updatedUser, value);
        });
        return userRepository.save(updatedUser);
    }

    public User updateUserDetailsWithNoUserId(User user) {
        List<User> users = userRepository.findAll();
        User updatedUser = null;
        for (User myUser : users) {
            if (myUser.getUserId() == user.getUserId()) {
                myUser.setName(user.getName());
                myUser.setEmail(user.getEmail());
                myUser.setMobile(user.getMobile());
                myUser.setGender(user.getGender());
                myUser.setAge(user.getAge());
                myUser.setNationality(user.getNationality());
                updatedUser = myUser;
                break;
            }
        }
        return userRepository.save(updatedUser);
    }

    public User getUserByUserEmail(String userEmail) throws UserNotFoundByEmailException {
        User userByEmail = userRepository.findByEmail(userEmail);
        if (userByEmail != null) {
            return userByEmail;
        } else {
            throw new UserNotFoundByEmailException("user not found by email :" + userEmail);
        }

    }
}
