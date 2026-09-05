package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.entity.Employee;
import org.example.repo.EmployeeRepositary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService{
    private EmployeeRepositary employeeRepositary;

    public EmployeeService(EmployeeRepositary employeeRepositary) {
        this.employeeRepositary = employeeRepositary;
    }

    public void saveEmployee(Employee e) {
        employeeRepositary.save(e);
    }

    public String getEmployeeName(int Id) {
        Optional<Employee> byId = employeeRepositary.findById(Id);
        if (byId.isPresent()) {
            return byId.get().getEmployeeName();
        }
        return "N/A";
    }
    public void getAllEmployee(){
        Iterable<Employee> all = employeeRepositary.findAll();
        all.forEach(System.out::println);
    }
    public void findAllById(Iterable<Integer> ids){
        Iterable<Employee> allById = employeeRepositary.findAllById(ids);
        allById.forEach(System.out::println);
    }
    public void getEmployeeByDepartment(String departmentId){
        List<Employee> byDepartment = employeeRepositary.findByDepartment(departmentId);
        byDepartment.forEach(System.out::println);
    }
    public void getEmployeeByGender(String gender){
        List<Employee> byGender = employeeRepositary.findByGender(gender);
        byGender.forEach(System.out::println);
    }
    public void getEmployeeByGenderAndDepartment(String gender,String dept){
        List<Employee> byGenderAndDepartment = employeeRepositary.findByGenderAndDepartment(gender, dept);
        byGenderAndDepartment.forEach(System.out::println);
    }
    public void getEmployeeById(String Id){
        List<Employee> employeeById = employeeRepositary.getEmployeeById(Id);
        employeeById.forEach(System.out::println);
    }

    public void getEmployeeBySalary(double salary){
        List<Employee> employeeBySalary = employeeRepositary.getEmployeeBySalary(salary);
        employeeBySalary.forEach(System.out::println);
    }

    public void deleteEmployeeBySalary(double salary){
        employeeRepositary.deleteEmployeeBySalary(salary);
    }
    public void insertEmployee(int Id,String name,String gender,String dept,double salary){
        employeeRepositary.insertEmployee(Id,name,gender,dept,salary);
    }
}
