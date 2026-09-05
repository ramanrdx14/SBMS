package org.example.repo;

import org.example.entity.BankName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankNameRepo extends JpaRepository<BankName,Integer> {
}
