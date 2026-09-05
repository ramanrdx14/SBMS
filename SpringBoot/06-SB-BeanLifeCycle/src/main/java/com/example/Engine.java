package com.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    @PostConstruct
    public void init(){
        System.out.println("Engine is starting ....");
    }
    public void start(){
        System.out.println("Emgine Started ::");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Engine is Stopped ....");
    }
}
