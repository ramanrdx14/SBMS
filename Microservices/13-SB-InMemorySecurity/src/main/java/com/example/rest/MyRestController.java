package com.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @GetMapping("/welcome")
    public String getWelcomeMsg(){
        return "Welcome";
    }

    @GetMapping("/greet")
    public String getGreetMsg(){
        return "Hello Good Evening";
    }
}