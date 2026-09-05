package org.example.rest;

import org.example.entity.Book;
import org.example.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {
    @Value("${msg}")
    String msg;
    @Autowired
    BookRepo bookRepo;
    @GetMapping("/welcome")
    public String welcome(){
        List<Book> all = bookRepo.findAll();
        return msg + all;
    }
}

