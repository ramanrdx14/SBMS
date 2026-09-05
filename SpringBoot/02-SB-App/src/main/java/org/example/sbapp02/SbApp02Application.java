package org.example.sbapp02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example.sbapp02","in.tcs"})
public class SbApp02Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SbApp02Application.class, args);
        System.out.println(context.getBeanDefinitionCount());
        context.getBean(ReportDao.class);
    }
}
