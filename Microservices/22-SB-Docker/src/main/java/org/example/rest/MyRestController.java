package org.example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/greet/{name}")
    public ResponseEntity<String> getGreetMessage(@PathVariable String name){
        return new ResponseEntity<>("Hello "+name+" Good Morning", HttpStatus.OK);
    }
}
