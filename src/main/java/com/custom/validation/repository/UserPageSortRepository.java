package com.custom.validation.repository;

import com.custom.validation.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * This repository and, it's component are for in built Paging and Sorting only
 */

public interface UserPageSortRepository extends PagingAndSortingRepository<User, Integer> {
}
