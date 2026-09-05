package org.example.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @GetMapping("/greet")
    public String greetUser(@RequestParam("user") String user){
        return "Hello "+user+" Good Morning";
    }
}
