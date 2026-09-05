package org.example.service;

import org.example.entity.Customer;
import org.example.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        Optional<Customer> customer = customerRepo.findById(customerId);
        return customer.orElse(null);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public void updateCustomerDetails(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerRepo.deleteById(customerId);
    }
}
