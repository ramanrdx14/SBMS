package org.example.repo;

import org.example.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositary extends CrudRepository<Book,Integer> {
}
