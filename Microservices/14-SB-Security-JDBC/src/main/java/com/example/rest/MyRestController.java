package com.example.rest;

import com.example.entity.Roles;
import com.example.entity.User;
import com.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class MyRestController {
    @Autowired
    UserRepo userRepo;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(user.getUserPassword());
        user.setUserPassword(encode);
        userRepo.save(user);
        return  new ResponseEntity<>("User Got Added !!",HttpStatus.ACCEPTED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userRepo.findAll(),HttpStatus.OK);
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h2>User is having Admin Role</h2>";
    }
    @GetMapping("/user")
    public String user(){
        return "<h2>User is having User Role</h2>";
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "<h2>Any body can access the URL</h2>";
    }
}