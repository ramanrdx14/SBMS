package org.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculaterController {

    private static final Logger log = LoggerFactory.getLogger(CalculaterController.class);

    @GetMapping("/")
    public String openPage(){
        return "index";
    }

    @GetMapping("/sum")
    @ResponseBody
    public Integer getSum(@RequestParam("num1") String num1,@RequestParam("num2") String num2){
        log.info(CalculaterController.class.getSimpleName(),"NUM1 ::"+num1);
        log.info(CalculaterController.class.getSimpleName(),"NUM1 ::"+num2);
        int total = Integer.parseInt(num1) + Integer.parseInt(num2);
        return total;
    }

}
