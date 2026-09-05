package org.example.repo;

import org.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepositary extends JpaRepository<Employee,Integer> {
}
