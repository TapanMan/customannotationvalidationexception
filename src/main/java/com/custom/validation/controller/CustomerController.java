package com.custom.validation.controller;

import com.custom.validation.entity.Customer;
import com.custom.validation.repository.CustomerRepository;
import com.custom.validation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private CustomerService service;
    private Logger logger = Logger.getLogger(CustomerController.class.getName());

    @GetMapping("/customers")
    @Cacheable("customers")
    public List<Customer> getAllCustomers() {
        logger.info("Fetching records from the Customers Table");
        return repository.findAll();
    }

    @GetMapping("/customer-name")
    public Customer getCustomerByCustomerName(@RequestParam(name = "cust-name") String customerName) {
        return service.getCustomerByName(customerName);
    }

    @GetMapping("/customer-name-address")
    public Customer getCustomerByCustomerNameAndAddress(@RequestParam(name = "cust-name") String customerName, @RequestParam(name = "cust-addr") String address) {
        return service.getCustomerByNameAddress(customerName, address);
    }

    @GetMapping("/customer-name-city")
    public List<Customer> getCustomerByContactNamesAndCity(@RequestParam(name = "customer-name") String custName, @RequestParam(name = "city") String city) {
        return service.getCustomerByContactAndCity(custName, city);
    }

    @GetMapping("/all-customers")
    public List<Customer> getAllCustomerDetails() {
        return service.getAllCustomer();
    }


    @GetMapping("/column-names")
    public List<String> getAllColumnNames() {
        return service.getAllColumnNames();
    }
}
