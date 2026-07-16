package com.example.employeemanagementsystem.repository;


import com.example.employeemanagementsystem.entity.Employee;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest
@ActiveProfiles("test")
class EmployeeRepositoryTest {



    @Autowired
    private EmployeeRepository employeeRepository;



    private Employee employee;



    @BeforeEach
    void setUp(){


        employee = new Employee();


        employee.setName("Shweta");

        employee.setEmail("shweta@gmail.com");

        employee.setDepartment("IT");

        employee.setPosition("Developer");

        employee.setSalary(50000.0);


    }




    @Test
    void testSaveEmployee(){


        Employee savedEmployee =
                employeeRepository.save(employee);



        assertNotNull(savedEmployee.getId());

        assertEquals(
                "Shweta",
                savedEmployee.getName()
        );


    }





    @Test
    void testFindEmployeeById(){


        Employee savedEmployee =
                employeeRepository.save(employee);



        Optional<Employee> result =
                employeeRepository.findById(
                        savedEmployee.getId()
                );



        assertTrue(result.isPresent());


        assertEquals(
                "Shweta",
                result.get().getName()
        );


    }





    @Test
    void testDeleteEmployee(){


        Employee savedEmployee =
                employeeRepository.save(employee);



        Long id =
                savedEmployee.getId();



        employeeRepository.deleteById(id);



        Optional<Employee> result =
                employeeRepository.findById(id);



        assertFalse(result.isPresent());


    }


}