package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee API", description = "Employee Management APIs")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create Employee
    @Operation(summary = "Create Employee")
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(
            @Valid @RequestBody Employee employee) {

        return ResponseEntity.ok(
                employeeService.saveEmployee(employee)
        );
    }

    // Get All Employees with Pagination & Sorting
    @Operation(summary = "Get Employees with Pagination and Sorting")
    @GetMapping
    public ResponseEntity<Page<Employee>> getEmployees(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "5") int size,

            @RequestParam(defaultValue = "id") String sortBy) {

        return ResponseEntity.ok(
                employeeService.getEmployees(page, size, sortBy)
        );
    }

    // Get Employee by ID
    @Operation(summary = "Get Employee By ID")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                employeeService.getEmployeeById(id)
        );
    }

    // Update Employee
    @Operation(summary = "Update Employee")
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {

        return ResponseEntity.ok(
                employeeService.updateEmployee(id, employee)
        );
    }

    // Delete Employee
    @Operation(summary = "Delete Employee")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok("Employee deleted successfully");
    }
}