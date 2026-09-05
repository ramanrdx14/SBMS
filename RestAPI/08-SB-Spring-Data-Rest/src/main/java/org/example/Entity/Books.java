package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String bookName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    String price;
}
