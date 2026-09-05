package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    UserController(){
        System.out.println("User Controller Obj Created");
    }
    @GetMapping("/user")
    public ModelAndView getUser(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("id","101");
        mav.addObject("name","chintu");
        mav.setViewName("user");
        return mav;
    }
}
