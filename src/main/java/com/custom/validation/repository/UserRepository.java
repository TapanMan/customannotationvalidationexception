package com.custom.validation.repository;

import com.custom.validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(int id);

    User findByEmail(String userEmail);
}
