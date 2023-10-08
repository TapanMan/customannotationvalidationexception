package com.custom.validation.entity;

import lombok.Data;

@Data
public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private int exp;

    public Employee() {
    }

    public Employee(String name, int age, int exp) {
        super();
        this.name = name;
        this.age = age;
        this.exp = exp;
    }

    @Override
    public int compareTo(Employee emp) {
        int result = Integer.compare(this.getAge(), emp.getAge());
        return result;
    }
}
