package org.example.controller;

import org.example.entity.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;


    @GetMapping("/show")
    public ModelAndView showAllBooks(){
        ModelAndView mav = new ModelAndView();
        List<Book> bookList =bookService.getAllBooks();
        mav.addObject("book",bookList);
        mav.setViewName("index");
        return  mav;
    }

    @GetMapping("/add")
    public ModelAndView addBooks(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("book",new Book());
        mav.setViewName("addbook");
        return  mav;
    }

    @PostMapping("/savebook")
    public ModelAndView saveBook(Book book){
        ModelAndView mav = new ModelAndView();
        boolean status = bookService.saveBook(book);
        if(status == true){
            mav.addObject("successmsg","Booked Saved Successfully.");
        }else{
            mav.addObject("successmsg","Booked ailed to save.");
        }
        mav.setViewName("addbook");
        return mav;
    }

    @GetMapping("/deletebook")
    public String deleteBooks(@RequestParam("bookId") String bookId){
        bookService.deleteBook(bookId);
        return "redirect:/book/show";
    }
    @GetMapping("/edit")
    public ModelAndView updateBooks(@RequestParam("bookId") String bookId){
        ModelAndView mav = new ModelAndView();
        Optional<Book> book = bookService.getBook(bookId);
        if(book.isPresent()){
            mav.addObject("book",book.get());
        }
        mav.setViewName("addbook");
        return mav;
    }
}
