package org.example;

import org.example.service.MyService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);
        MyService bean = context.getBean(MyService.class);
        bean.callCatFacts();
    }

}
