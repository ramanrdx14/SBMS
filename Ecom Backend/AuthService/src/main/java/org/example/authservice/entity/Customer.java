package org.example.authservice.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Integer customerId;
   String  customerName;
   String  customerEmail;
   String  customerPwd;
   @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JoinTable(name = "customers_roles",
   joinColumns = {
           @JoinColumn(name = "customer_id")
   },inverseJoinColumns = {
           @JoinColumn(name = "role_id")
   })
   List<Roles> roles;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPwd() {
        return customerPwd;
    }

    public void setCustomerPwd(String customerPwd) {
        this.customerPwd = customerPwd;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
