package org.example;

import org.example.entity.Employee;
import org.example.repo.EmployeeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepository repo;
    public EmployeeService(EmployeeRepository repo){
        this.repo = repo;
    }
    public void getEmployeeWithPagination(int pageNo,int pageSize){
        PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize);
        Page<Employee> all = repo.findAll(pageRequest);
        List<Employee>  employeeList = all.getContent();
        employeeList.forEach(System.out::println);
    }
    public void getEmployeeByQBE(){
        Employee emp = new Employee();
        //If the user selected department set the department value to entity
        emp.setDepartment("IT");
        Example<Employee> of = Example.of(emp);
        List<Employee> allEmployee = repo.findAll(of);
        allEmployee.forEach(System.out::println);
    }
}
