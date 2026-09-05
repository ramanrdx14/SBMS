package org.example;

import org.example.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);
        EmployeeService service = context.getBean(EmployeeService.class);
        //service.saveEmployee();
        service.findEmployeeWithId(1);
    }

}
