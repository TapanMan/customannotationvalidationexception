package com.custom.validation.repository;

import com.custom.validation.entity.MandalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MandalUserRepository extends JpaRepository<MandalUser, Integer> {
    MandalUser findByUserName(String username);
}
