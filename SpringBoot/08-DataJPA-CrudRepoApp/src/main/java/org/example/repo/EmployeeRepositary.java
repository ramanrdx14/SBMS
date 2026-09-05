package org.example.repo;

import jakarta.transaction.Transactional;
import org.example.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepositary extends CrudRepository<Employee,Integer> {
    public List<Employee> findByDepartment(String dept);
    public List<Employee> findByGender(String gender);
    public List<Employee> findByGenderAndDepartment(String gender,String dept);

    //If we write HQL Query
    @Query("from Employee emp where emp.id = :Id")
    public List<Employee> getEmployeeById(String Id);

    //Normal SQL Query
    @Query(value = "select * from employee where salary = :salary",nativeQuery = true)
    public List<Employee> getEmployeeBySalary(double salary);

    @Transactional
    @Modifying
    @Query("delete from Employee where salary = :salary")
    public void deleteEmployeeBySalary(double salary);

    @Transactional
    @Modifying
    @Query(value = "insert into employee values(:Id,:name,:gender,:dept,:salary)",nativeQuery = true)
    public void insertEmployee(int Id,String name,String gender,String dept,double salary);
}
