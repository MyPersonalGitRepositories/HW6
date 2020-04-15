package com.example.HW6.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Book {

    @Column(name = "title")
    @NotNull
    @Size(min = 1, max = 200)
    private String title;

    @Column(name = "isbn")
    @NotNull
    private String isbn;

    @Column(name = "author")
    @NotNull
    @Size(min = 1, max = 200)
    private String author;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "user_to_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
}
