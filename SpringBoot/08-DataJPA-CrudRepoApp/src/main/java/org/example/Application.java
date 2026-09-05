package org.example;

import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        /*
         *
         *
        System.out.println(employeeService.getEmployeeName(102));
        Iterable<Integer> itr = Arrays.asList(101,102);
        employeeService.findAllById(itr);

        employeeService.getAllEmployee();
         *
         */

           //employeeService.getEmployeeByDepartment("IT");
          //employeeService.getEmployeeByGender("Female");
         // employeeService.getEmployeeByGenderAndDepartment("Male","IT");
        //employeeService.getEmployeeById("101");

        //employeeService.getEmployeeBySalary(10000);
        //employeeService.deleteEmployeeBySalary(20000);

        //employeeService.insertEmployee(111,"sunny","male","IT",20000);
    }

}
