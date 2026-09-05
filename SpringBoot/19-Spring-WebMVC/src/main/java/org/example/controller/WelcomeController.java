package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
    WelcomeController(){
        System.out.println("Welcome Controller object created");
    }

    @GetMapping("/welcome")
    public ModelAndView getWelcomeMessege(){
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("msg","Hello Dear!!");
        modelView.setViewName("index");
        return modelView;
    }
}
