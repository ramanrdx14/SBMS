package org.example.services;

import org.example.entity.Employee;
import org.example.repo.EmployeeRepositary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
    @Mock
    EmployeeRepositary employeeRepositary;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    //Test-Case-1
    @Test
    public void getAllEmployee(){
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        when(employeeRepositary.findAll()).thenReturn(Arrays.asList(e1,e2));
        assertEquals(Arrays.asList(e1,e2),employeeService.getAllEmployee());
    }

    //Test-Case-2
    @Test
    public void addEmployee(){
        Employee e1 = new Employee();
        when(employeeRepositary.save(e1)).thenReturn(e1);
        assertEquals(true,employeeService.addEmployee(e1));
    }

    //Test-Case-3
    @Test
    public void addEmployeeExceptionTest(){
        Exception exception = new RuntimeException("DB error");
        Employee e1 = new Employee();
        when(employeeRepositary.save(e1)).thenThrow(exception);
        assertEquals(false,employeeService.addEmployee(e1));
    }

}
