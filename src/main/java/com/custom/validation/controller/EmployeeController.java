package com.custom.validation.controller;

import com.custom.validation.entity.Employee;
import com.custom.validation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/sort-comparable")
    public List<Employee> getEmpList() {
        List<Employee> empController = employeeService.getEmployees();
        Collections.sort(empController);
        return empController;
    }
}
