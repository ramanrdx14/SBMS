package org.example.rest;

import org.example.entity.Employee;
import org.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class MyRestController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> allEmployee(){
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<String> allEmployee(@RequestBody Employee employee){
        boolean b = employeeService.addEmployee(employee);
        if(b){
            return  new ResponseEntity<>("Employee Added Successfully",HttpStatus.OK);
        }
        return  new ResponseEntity<>("Employee Failed to add",HttpStatus.valueOf(500));
    }
}
