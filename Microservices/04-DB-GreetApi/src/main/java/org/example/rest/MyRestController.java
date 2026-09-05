package org.example.rest;

import org.example.client.WelcomeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @Autowired
    WelcomeApi welcomeApi;

    @GetMapping("/greet")
    public String greetApi(){
        String welcomeData = welcomeApi.getWelcomeData();
        return welcomeData +" Admin";
    }
}
