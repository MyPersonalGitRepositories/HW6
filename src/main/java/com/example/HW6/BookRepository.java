package com.example.HW6;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {

    private final List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    public List<Book> findAll() {
        return books;
    }

    public void save(final Book book) {
        books.add(book);
    }

}
