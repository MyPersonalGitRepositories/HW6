package com.example.HW6.dto;

import com.example.HW6.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class ToDTO {
    public static BookDTO toBookDTO(final Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .build();
    }

    public static List<BookDTO> toBookDTOList(final List<Book> books) {
        List<BookDTO> res = new ArrayList<>();
        for (Book book : books) {
            res.add(toBookDTO(book));
        }
        return res;
    }
}
