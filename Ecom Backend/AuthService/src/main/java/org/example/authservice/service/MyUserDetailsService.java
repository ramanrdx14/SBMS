package org.example.authservice.service;

import org.example.authservice.entity.Customer;
import org.example.authservice.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
        Customer customer = customerRepo.findByCustomerEmail(useremail);
        List<GrantedAuthority> authorityList = customer.getRoles().stream().map(r->new SimpleGrantedAuthority(r.getRoleName())).collect(Collectors.toList());
        System.out.println("Authorthies ::::"+customer.getCustomerEmail()+"--"+customer.getCustomerPwd()+"--"+authorityList.toString());
        return new User(customer.getCustomerEmail(),customer.getCustomerPwd(), authorityList);
    }
}
