package com.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car implements DisposableBean,InitializingBean{
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car is Starting ...");
    }


    public void drive(){
        System.out.println("I am Driving ....");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("Car is Sopped ...");
    }
}
