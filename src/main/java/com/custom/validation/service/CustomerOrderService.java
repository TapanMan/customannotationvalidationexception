package com.custom.validation.service;

import com.custom.validation.entity.CustomerOrder;
import com.custom.validation.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * This service class is with Embedded implementation
 */
@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    public List<CustomerOrder> getAllCustomerOrder() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        List<CustomerOrder> customerOrders = customerOrderRepository.findAll();
        for (CustomerOrder customerOrder : customerOrders) {
            LocalDateTime orderDate = customerOrder.getOrderDate();
            orderDate.format(dateTimeFormatter);
            customerOrder.setOrderDate(orderDate);
        }
        return customerOrders;
    }
}
