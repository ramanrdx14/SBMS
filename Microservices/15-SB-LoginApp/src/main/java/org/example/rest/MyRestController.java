package org.example.rest;

import org.example.entity.Customer;
import org.example.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer){
        String encode = passwordEncoder.encode(customer.getCpwd());
        customer.setCpwd(encode);
        customerRepo.save(customer);
        return new ResponseEntity<>("Customer Register Successfully!!", HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody Customer customer){
        Authentication authentication = new UsernamePasswordAuthenticationToken(customer.getCname(),customer.getCpwd());
        try{
            Authentication authenticate = authenticationManager.authenticate(authentication);
            return new ResponseEntity<>("Customer Login Sucessfully", HttpStatus.ACCEPTED);
        }catch (BadCredentialsException exception){
            return new ResponseEntity<>("Authentication Failed !! ",HttpStatus.BAD_REQUEST);
        }
    }


}
