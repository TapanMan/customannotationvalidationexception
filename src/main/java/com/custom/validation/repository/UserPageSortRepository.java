package com.custom.validation.repository;

import com.custom.validation.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPageSortRepository extends PagingAndSortingRepository<User, Integer> {
}
