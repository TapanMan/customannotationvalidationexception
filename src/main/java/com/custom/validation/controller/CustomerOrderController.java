package com.custom.validation.controller;

import com.custom.validation.entity.CustomerOrder;
import com.custom.validation.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This controller is meant for Embedded flow
 */
@RestController
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;
    @GetMapping("/customer-orders")
    public ResponseEntity<List<CustomerOrder>> getAllCustomerOrder() {
        return new ResponseEntity<>(customerOrderService.getAllCustomerOrder(), HttpStatus.OK);
    }
}
