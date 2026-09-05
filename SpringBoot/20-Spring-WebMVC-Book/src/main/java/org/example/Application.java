package org.example;

import org.example.entity.Book;
import org.example.repo.BookRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
       ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);
       context.getBean(BookRepo.class);
    }

}
