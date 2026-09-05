package org.example.rest;

import org.example.Application;
import org.example.exception.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class MyRestController {
    @GetMapping("/")
    public String greet(){
        int len = 10/0;
        return "Hello World";
    }
    @GetMapping("/{name}")
    public String greet(@PathVariable String name){
        String x = null;
        int len = x.length();
        return "Hello World";
    }
    @ExceptionHandler(value = ArithmeticException.class)
    public ResponseEntity<AppException> handleException(ArithmeticException exception){
        AppException appException = new AppException();
        appException.setExceptionName(exception.getClass().getName());
        appException.setMsg(exception.getMessage());
        appException.setExceptionTime(LocalDate.now());
        return new ResponseEntity<>(appException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
