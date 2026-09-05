package org.example.services;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public boolean addEmployee(Employee employee);
}
