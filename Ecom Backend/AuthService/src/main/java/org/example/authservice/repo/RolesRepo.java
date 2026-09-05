package org.example.authservice.repo;

import org.example.authservice.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RolesRepo extends JpaRepository<Roles,Integer> {
}
