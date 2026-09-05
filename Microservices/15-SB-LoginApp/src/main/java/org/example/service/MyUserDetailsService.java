package org.example.service;

import org.example.entity.Customer;
import org.example.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepo.findByCname(username);
        return new User(customer.getCname(),customer.getCpwd(), Collections.emptyList());
    }
}
