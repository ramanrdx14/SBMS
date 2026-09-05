package org.example.service;

import org.example.entity.Book;
import org.example.entity.BookPK;
import org.example.repo.BookRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepositary bookRepositary;

    public void saveBook(){
        BookPK pk = new BookPK("101","Java");
        Book book = new Book("James",100.34,pk);
        bookRepositary.save(book);
    }
    public void findBook(String bookId,String bookName){
        BookPK pk = new BookPK("101","Java");
        Optional<Book> byId = bookRepositary.findById(pk);
        if(byId.isPresent()){
            System.out.println(byId.get().getAuthorName());
            System.out.println(byId.get().getPrice());
        }
    }
}
