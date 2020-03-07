package com.example.HW6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(query = "SELECT b FROM Book b", name = Book.FIND_ALL),
        @NamedQuery(query = "SELECT b FROM Book b WHERE b.title LIKE CONCAT('%', :title, '%')", name = Book.FIND_ALL_BY_TITLE)
})
public class Book {

    public static final String FIND_ALL = "Book.FIND_ALL";
    public static final String FIND_ALL_BY_TITLE = "Book.FIND_ALL_BY_TITLE";

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "author")
    private String author;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
