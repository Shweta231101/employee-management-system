package com.example.employeemanagementsystem.service;


import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import com.example.employeemanagementsystem.service.impl.EmployeeServiceImpl;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {



    @Mock
    private EmployeeRepository employeeRepository;



    @InjectMocks
    private EmployeeServiceImpl employeeService;




    @Test
    void saveEmployeeTest(){


        Employee employee = new Employee();


        employee.setName("Shweta");

        employee.setEmail("shweta@gmail.com");

        employee.setDepartment("IT");

        employee.setPosition("Developer");

        employee.setSalary(50000.0);



        when(employeeRepository.save(employee))
                .thenReturn(employee);



        Employee result =
                employeeService.saveEmployee(employee);



        assertNotNull(result);

        assertEquals(
                "Shweta",
                result.getName()
        );


        verify(employeeRepository)
                .save(employee);

    }





    @Test
    void getEmployeeByIdTest(){


        Employee employee = new Employee();


        employee.setId(1L);

        employee.setName("Shweta");

        employee.setEmail("shweta@gmail.com");



        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));



        Employee result =
                employeeService.getEmployeeById(1L);



        assertNotNull(result);


        assertEquals(
                1L,
                result.getId()
        );


        assertEquals(
                "Shweta",
                result.getName()
        );

    }





    @Test
    void employeeNotFoundTest(){



        when(employeeRepository.findById(100L))
                .thenReturn(Optional.empty());



        assertThrows(
                RuntimeException.class,
                () -> employeeService.getEmployeeById(100L)
        );


    }


}