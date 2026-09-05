package org.example.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class BookPK {
    String bookId;

    public BookPK() {
    }

    String bookName;
    public BookPK(String bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
