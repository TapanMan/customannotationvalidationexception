package com.custom.validation.service;

import com.custom.validation.controller.CustomerController;
import com.custom.validation.entity.Customer;
import com.custom.validation.repository.CustomerRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    private Logger logger = Logger.getLogger(CustomerService.class.getName());

    public Customer getCustomerByName(String customerName) {
        return repository.getCustomerByCustomerName(customerName);
    }

    public Customer getCustomerByNameAddress(String customerName, String address) {
        return repository.getCustomerByNameAndAddress(customerName, address);
    }

    public List<Customer> getCustomerByContactAndCity(String contactName, String city) {
        return repository.getCustomerByContactNameAndCity(contactName, city);
    }

    public List<Customer> getAllCustomer() {
        return repository.getAllCustomer();
    }

    public List<String> getAllColumnNames() {
        List<String> columns = new ArrayList<>();
        Field[] fields = Customer.class.getDeclaredFields();
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                columns.add(column.name());
                logger.info("Column " + column);
            }
        }
        return columns;
    }
}
