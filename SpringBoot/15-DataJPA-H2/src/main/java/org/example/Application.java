package org.example;

import org.example.entity.Employees;
import org.example.repo.EmployeesRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
       ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);
        EmployeesRepo repo = context.getBean(EmployeesRepo.class);
        Employees emp = new Employees();
        emp.setEmpName("Raju");
        emp.setEmpSalary(10000.0);
        repo.save(emp);
    }

}
