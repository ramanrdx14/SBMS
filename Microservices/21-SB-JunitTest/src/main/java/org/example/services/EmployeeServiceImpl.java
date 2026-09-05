package org.example.services;

import org.example.entity.Employee;
import org.example.repo.EmployeeRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepositary employeeRepositary;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepositary.findAll();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        try{
            employeeRepositary.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
