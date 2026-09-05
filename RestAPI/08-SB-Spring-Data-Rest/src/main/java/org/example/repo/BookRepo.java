package org.example.repo;

import org.example.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "books")
public interface BookRepo extends JpaRepository<Books,Integer> {
    public Optional<Books> findByBookName(@RequestParam("bookName") String bookName);

    String query = "select * from book where price between :price1 and :price2 ";
    @Query(nativeQuery = true,value = query)
    public List<Books> getBookByPriceRange(@Param("price1") String price1,@Param("price2") String price2);

}
