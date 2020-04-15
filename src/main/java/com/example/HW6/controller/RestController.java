package com.example.HW6.controller;


import com.example.HW6.BookRepository;
import com.example.HW6.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {
    private final BookRepository bookRepository;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody final Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> findById(@PathVariable int id) {
        //TODO
        Book book = bookRepository.findById(id).orElse(null);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> findByTitleOrIsbn(@RequestParam(name = "text", required = false) final String text) {
        List<Book> books;
        if (text == null) {
            books = bookRepository.findAll();
        } else books = bookRepository.findAllByTitleOrIsbn(text);
        return ResponseEntity.ok(books);
    }
}
