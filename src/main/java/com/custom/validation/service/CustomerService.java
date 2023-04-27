package com.custom.validation.service;

import com.custom.validation.entity.Customer;
import com.custom.validation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer getCustomerByName(String customerName) {
        return repository.getCustomerByCustomerName(customerName);
    }

    public Customer getCustomerByNameAddress(String customerName, String address) {
        return repository.getCustomerByNameAndAddress(customerName, address);
    }

    public List<Customer> getCustomerByContactAndCity(String contactName, String city) {
        return repository.getCustomerByContactNameAndCity(contactName, city);
    }
}
