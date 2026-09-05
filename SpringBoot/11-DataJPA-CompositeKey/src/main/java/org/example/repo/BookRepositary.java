package org.example.repo;

import org.example.entity.Book;
import org.example.entity.BookPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositary extends JpaRepository<Book, BookPK> {
}
