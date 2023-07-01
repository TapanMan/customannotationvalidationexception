package com.custom.validation.service;

import com.custom.validation.entity.CustomerOrder;
import com.custom.validation.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This service class is with Embedded implementation
 */
@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    public List<CustomerOrder> getAllCustomerOrder() {
        return customerOrderRepository.findAll();
    }
}
