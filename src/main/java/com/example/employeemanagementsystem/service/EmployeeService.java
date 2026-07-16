package com.example.employeemanagementsystem.service;

import org.springframework.data.domain.Page;

import com.example.employeemanagementsystem.entity.Employee;


public interface EmployeeService {


    Employee saveEmployee(Employee employee);


    Page<Employee> getEmployees(
            int page,
            int size,
            String sortBy
    );


    Employee getEmployeeById(Long id);


    Employee updateEmployee(
            Long id,
            Employee employee
    );


    void deleteEmployee(Long id);

}