package org.example.controller;

import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class MyController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/{cid}",produces = "application/json")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer cid){
        Customer customer = customerService.getCustomer(cid);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @GetMapping(value = "/all",produces = "application/json")
    public ResponseEntity<List<Customer>> getCustomer(){
        List<Customer> customer = customerService.getAllCustomer();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public ResponseEntity<Void> addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/update",consumes = "application/json")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomerDetails(customer);
        return new ResponseEntity<>("Customer Updated",HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam("cid") Integer cid){
        customerService.deleteCustomer(cid);
        return new ResponseEntity<>("Customer Deleted",HttpStatus.NO_CONTENT);
    }
}
