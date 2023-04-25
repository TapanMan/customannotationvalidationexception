package com.custom.validation.service;

import com.custom.validation.entity.Customer;
import com.custom.validation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer getCustomerByName(String customerName) {
        return repository.getCustomerByCustomerName(customerName);
    }
}
