package com.custom.validation.controller;

import com.custom.validation.entity.Customer;
import com.custom.validation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * This controller and it's component are for Customers only
 */
@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    private Logger logger = Logger.getLogger(CustomerController.class.getName());

    @GetMapping("/customers")
    @Cacheable("customers")
    public List<Customer> getAllCustomers() {
        logger.info("Fetching records from the Customers Table");
        return repository.findAll();
    }
}
