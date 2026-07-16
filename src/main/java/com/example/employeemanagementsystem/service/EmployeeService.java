package com.example.employeemanagementsystem.service;


import com.example.employeemanagementsystem.entity.Employee;

import java.util.List;


public interface EmployeeService {


    Employee saveEmployee(Employee employee);


    List<Employee> getEmployees(int page, int size, String sortBy);


    List<Employee> getAllEmployees();


    Employee getEmployeeById(Long id);


    Employee updateEmployee(Long id, Employee employee);


    void deleteEmployee(Long id);

}