package com.example.HW6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM BookEntity b " +
            "WHERE b.title LIKE :string " +
            "OR b.isbn LIKE :string")
    List<Book> findAllByTitleOrIsbn(@Param("string") String string);
}
