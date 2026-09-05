package org.example.repo;

import org.example.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRpo extends JpaRepository<Roles,Integer> {
}
