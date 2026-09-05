package org.example.rest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @GetMapping("/greet")
    @CircuitBreaker(name = "test" ,fallbackMethod = "fallBackMethodTest")
    public String greet(){

        // fetch data from redis
        //int x = 10/0;  //ArithmeticException occour
        // get some exception while fetching data from redis

        return "Fetching Data from Redis!!";
    }

    public String fallBackMethodTest(Throwable throwable){
        return  "Fetching Data from fallBackMethod !!";
    }
}
