package org.example.repo;

import org.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    //Projection

    @Query(value = "select emp.employee_id,emp.first_name,addr.city,addr.country from employee_txn emp join address_txn addr on addr.employee_id = emp.employee_id where emp.employee_id = :employeeId",nativeQuery = true)
    List<Object[]> findEmpById(Integer employeeId);
}
