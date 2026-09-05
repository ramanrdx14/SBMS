package org.example;

import org.example.entity.Employee;
import org.example.repo.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        //EmployeeRepository empRepo             = context.getBean(EmployeeRepository.class);

        //Get Employee With Sorting
        //List<Employee> allEmployeeDesc = empRepo.findAll(Sort.by(Sort.Direction.DESC,"salary"));
        //List<Employee> allEmployeeASC = empRepo.findAll(Sort.by(Sort.Direction.ASC,"salary"));


        //Implemented Pagination
        EmployeeService empservice = context.getBean(EmployeeService.class);
        //empservice.getEmployeeWithPagination(2,4);

        empservice.getEmployeeByQBE();
    }

}
