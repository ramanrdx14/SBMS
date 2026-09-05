package org.example.service;

import org.example.entity.Customer;

import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer customer);
    public Customer getCustomer(Integer customerId);
    public List<Customer> getAllCustomer();
    public void updateCustomerDetails(Customer customer);
    public void deleteCustomer(Integer customerId);
}
