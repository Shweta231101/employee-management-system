package com.example.employeemanagementsystem.service.impl;


import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import com.example.employeemanagementsystem.service.EmployeeService;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;

    }



    // Create Employee
    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);

    }



    // Pagination + Sorting
    @Override
    public List<Employee> getEmployees(int page, int size, String sortBy) {


        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).ascending()
        );


        Page<Employee> employeePage =
                employeeRepository.findAll(pageable);


        return employeePage.getContent();

    }



    // Get All Employees
    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();

    }




    // Get Employee By Id
    @Override
    public Employee getEmployeeById(Long id) {


        return employeeRepository.findById(id)
                .orElseThrow(
                        () -> new EmployeeNotFoundException(
                                "Employee not found with id : " + id
                        )
                );

    }




    // Update Employee
    @Override
    public Employee updateEmployee(Long id, Employee employee) {


        Employee existingEmployee =
                getEmployeeById(id);



        existingEmployee.setName(employee.getName());

        existingEmployee.setEmail(employee.getEmail());

        existingEmployee.setDepartment(employee.getDepartment());

        existingEmployee.setPosition(employee.getPosition());

        existingEmployee.setSalary(employee.getSalary());

        existingEmployee.setDateOfJoining(employee.getDateOfJoining());



        return employeeRepository.save(existingEmployee);

    }





    // Delete Employee
    @Override
    public void deleteEmployee(Long id) {


        Employee employee =
                getEmployeeById(id);


        employeeRepository.delete(employee);

    }

}