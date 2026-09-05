package org.example.service;

import org.example.entity.Book;
import org.example.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepo bookRepo;

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public boolean saveBook(Book book) {
        Book save = bookRepo.save(book);
        return save.getBookId() != null;
    }

    @Override
    public void deleteBook(String bookId) {
        bookRepo.deleteById(bookId);
    }

    @Override
    public Optional<Book> getBook(String bookId) {
        return bookRepo.findById(bookId);
    }
}
