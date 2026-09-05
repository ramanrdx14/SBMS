package org.example.db2.repo;

import org.example.db2.entity.Charger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharagerRepo extends JpaRepository<Charger,Integer> {
}
