package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController1 {
    @GetMapping("/greet1")
    @ResponseBody
    public String greetMessege(){
        int x = 10/0;
        return "hello - 1";
    }

    /**
     * Firstly it will check if local exception handing present or not if present it will handled by local
     * else it will handled by global.
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String handleException(){
        return "errorviewlocal";
    }
}
