package org.example.repo;

import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    public Student findByStdName(String name);
}
