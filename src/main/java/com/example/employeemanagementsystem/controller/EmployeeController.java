package com.example.employeemanagementsystem.controller;


import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;


import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService){

        this.employeeService = employeeService;

    }



    // CREATE EMPLOYEE
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(
            @Valid @RequestBody Employee employee){


        Employee savedEmployee =
                employeeService.saveEmployee(employee);


        return new ResponseEntity<>(
                savedEmployee,
                HttpStatus.CREATED
        );

    }



    // GET ALL WITH PAGINATION + SORTING
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy){



        List<Employee> employees =
                employeeService.getEmployees(page,size,sortBy);



        return ResponseEntity.ok(employees);

    }




    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable Long id){



        Employee employee =
                employeeService.getEmployeeById(id);



        return ResponseEntity.ok(employee);

    }





    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee){



        Employee updatedEmployee =
                employeeService.updateEmployee(id,employee);



        return ResponseEntity.ok(updatedEmployee);

    }




    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id){



        employeeService.deleteEmployee(id);



        return ResponseEntity.ok(
                "Employee deleted successfully"
        );

    }

}