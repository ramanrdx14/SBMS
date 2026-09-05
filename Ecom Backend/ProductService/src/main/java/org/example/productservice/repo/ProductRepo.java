package org.example.productservice.repo;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.productservice.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products, Integer> {
}
