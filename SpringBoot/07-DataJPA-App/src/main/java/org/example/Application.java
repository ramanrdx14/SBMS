package org.example;

import org.example.repo.BookRepositary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        BookRepositary repo = context.getBean(BookRepositary.class);
        Book book = new Book();
        book.setBookName("Python");
        book.setPrice(1325.95);
        book.setId(2);
        repo.save(book);
    }

}
