package org.example.repo;

import org.example.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepo extends JpaRepository<Employees,Integer> {
}
