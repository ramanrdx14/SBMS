package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController2 {
    @GetMapping("/greet2")
    @ResponseBody
    public String greetMessege(){
        return "hello - 2";
    }
}
