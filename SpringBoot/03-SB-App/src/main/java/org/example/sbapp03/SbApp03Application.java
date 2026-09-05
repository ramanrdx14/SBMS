package org.example.sbapp03;

import org.example.sbapp03.Service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbApp03Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SbApp03Application.class, args);
        UserService bean = context.getBean(UserService.class);
        bean.getName(10);

    }

}
