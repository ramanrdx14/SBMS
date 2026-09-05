package org.example.rest;

import org.example.entity.Employee;
import org.example.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tools.jackson.databind.ObjectMapper;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = MyRestController.class)
public class MyRestControllerTest {
    @MockitoBean
    EmployeeService employeeService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testGetAllEmployee() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/all");
        Employee employee =  new Employee();
        employee.setId(999);
        employee.setEmployeeName("Singh");
        employee.setDepartment("IT");
        employee.setGender("Male");
        employee.setSalary(2000.09);
        when(employeeService.getAllEmployee()).thenReturn(Arrays.asList(employee));
        mockMvc.perform(requestBuilder)
                .andExpect(status->assertEquals(status.getResponse().getStatus(), 200));
    }

    //Test Case-1
    @Test
    public void testAddEmployee()throws Exception {
        Employee employee =  new Employee();
        employee.setId(999);
        employee.setEmployeeName("Singh");
        employee.setDepartment("IT");
        employee.setGender("Male");
        employee.setSalary(2000.09);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee));

        when(employeeService.addEmployee(any(Employee.class))).thenReturn(true);
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    //Test Case 2 if any error
    @Test
    public void testAddEmployeeTest2()throws Exception {
        Employee employee =  new Employee();
        employee.setId(999);
        employee.setEmployeeName("Singh");
        employee.setDepartment("IT");
        employee.setGender("Male");
        employee.setSalary(2000.09);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee));

        when(employeeService.addEmployee(employee)).thenReturn(false);
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}
