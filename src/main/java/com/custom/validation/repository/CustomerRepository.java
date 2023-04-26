package com.custom.validation.repository;

import com.custom.validation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * This repository and it's component are for Customers only
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // This is SQL [select * from customers where customer_name =], The table name and column name must match
    @Query(value = "select * from customers where customer_name =:custName", nativeQuery = true)
    Customer getCustomerByCustomerName(String custName);

    @Query(value = "select * from customers where customer_name =:custName and address =:addr", nativeQuery = true)
    Customer getCustomerByNameAndAddress(String custName, String addr);
}