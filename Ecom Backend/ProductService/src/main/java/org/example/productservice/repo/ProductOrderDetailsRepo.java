package org.example.productservice.repo;

import org.example.productservice.entity.ProdOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderDetailsRepo extends JpaRepository<ProdOrderDetails,Integer> {
}
