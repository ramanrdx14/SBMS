package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
    DemoController(){
        System.out.println("Demo controller object created");
    }

    @GetMapping("/demo2/{name}")
    public ModelAndView getMsg1(@PathVariable String name){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg",name);
        mav.setViewName("index");
        return  mav;
    }

    @GetMapping("/demo1")
    public ModelAndView getMsg2(@RequestParam("msg") String msg){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg",msg);
        mav.setViewName("index");
        return  mav;
    }

    @GetMapping("/demo3")
    public String getMsg3(@RequestParam("msg") String msg, Model model){
        model.addAttribute("msg",msg);
        return "index";
    }

    @GetMapping("/demo4")
    @ResponseBody
    public String getMsg4(){
        return  "Hello Friend ";
    }
}
