package org.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/welcome")
    public String welcomeAPI() {
        return "Hello Dear Good Morning!";
    }
}