package com.custom.validation.repository;

import com.custom.validation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This repository and it's component are for Customers only
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
