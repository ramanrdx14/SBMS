package org.example.service;

import org.example.entity.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAllBooks();
    public boolean saveBook(Book book);
    public void deleteBook(String bookId);
    public Optional<Book> getBook(String bookId);
}
