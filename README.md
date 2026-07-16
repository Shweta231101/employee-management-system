# Employee Management System

## Project Description

Employee Management System is a Spring Boot REST API project developed using Java, Spring Boot, Spring Security, JWT Authentication, Hibernate, and MySQL.

This application provides secure Employee CRUD operations with JWT authentication and Swagger API documentation.

---

## Features

- User Registration
- User Login
- JWT Authentication
- Spring Security
- Employee CRUD Operations
- Validation
- Exception Handling
- Pagination
- Sorting
- Swagger Documentation
- MySQL Database Integration

---

## Technologies Used

- Java 17
- Spring Boot 3.5.3
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger OpenAPI

---

## Database

Database Name

employee_db

---
## Unit Testing

Unit tests are implemented using:

- JUnit 5
- Mockito
- Spring Boot Test


Test cases covered:

- Employee Service Testing
- Employee Repository Testing


Test Result: 
Tests run: 7
Failures: 0
Errors: 0
Skipped: 0

## Default Login

Username

admin

Password

admin123

---

## API Endpoints

### Authentication

POST

/auth/register

POST

/auth/login

### Employee

POST

/api/employees

GET

/api/employees

GET

/api/employees/{id}

PUT

/api/employees/{id}

DELETE

/api/employees/{id}

---

## Swagger

Open

http://localhost:8080/swagger-ui/index.html

Login

Copy JWT Token

Click Authorize

Paste Token

Test APIs

---

## How To Run

Clone Project

Open in IntelliJ IDEA

Create MySQL Database

employee_db

Update

application.properties

Run

EmployeeManagementSystemApplication.java

Open Swagger

http://localhost:8080/swagger-ui/index.html

---

## Author

Shweta Jadhav
