package org.example.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="BookInfo")
public class Book {
    String authorName;
    Double price;
    @EmbeddedId
    BookPK key;

    public Book() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Book(String authorName, Double price, BookPK key) {
        this.authorName = authorName;
        this.price = price;
        this.key = key;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BookPK getKey() {
        return key;
    }

    public void setKey(BookPK key) {
        this.key = key;
    }
}
