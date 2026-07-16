package com.example.employeemanagementsystem.entity;


import jakarta.persistence.*;

import java.time.LocalDate;



@Entity
@Table(name = "employees")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String email;


    private String department;


    private String position;


    private Double salary;


    private LocalDate dateOfJoining;



    public Employee() {
    }



    public Employee(Long id, String name, String email,
                    String department, String position,
                    Double salary, LocalDate dateOfJoining) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;

    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public String getPosition() {
        return position;
    }


    public void setPosition(String position) {
        this.position = position;
    }


    public Double getSalary() {
        return salary;
    }


    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }


    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

}