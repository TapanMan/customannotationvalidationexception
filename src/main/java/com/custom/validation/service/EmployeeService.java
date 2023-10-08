package com.custom.validation.service;

import com.custom.validation.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    public List<Employee> getEmployees() {
        List<Employee> emp = new ArrayList<>();
        Employee emp1 = new Employee("Sandhya", 20, 0);
        Employee emp2 = new Employee("Kemp", 24, 2);
        Employee emp3 = new Employee("Anil", 22, 3);
        Employee emp4 = new Employee("Kumar", 30, 6);
        Employee emp5 = new Employee("Tim", 32, 7);
        emp.add(emp1);
        emp.add(emp2);
        emp.add(emp3);
        emp.add(emp4);
        emp.add(emp5);

        return emp;
    }
}
