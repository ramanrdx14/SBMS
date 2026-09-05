package org.example.authservice.repo;

import org.example.authservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    public Customer findByCustomerEmail(String email);
}
