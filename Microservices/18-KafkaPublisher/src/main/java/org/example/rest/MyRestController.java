package org.example.rest;

import org.example.bindings.Orders;
import org.example.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @Autowired
    MyService myService;

    @PostMapping("/msg")
    public ResponseEntity<String> sendMessage(@RequestBody Orders orders){
        String msg = myService.sendMessage(orders);
        return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
    }
}
