package org.example.repo;

import org.example.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepo extends JpaRepository<People,Integer> {
}
