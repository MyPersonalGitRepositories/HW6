package com.example.HW6;

import com.example.HW6.entities.Book;
import com.example.HW6.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b " +
            "WHERE b.title LIKE :string " +
            "OR b.isbn LIKE :string")
    List<Book> findAllByTitleOrIsbn(@Param("string") String string);

    @Query("SELECT b FROM Book b "
            + "JOIN b.users user "
            + "WHERE user.id = :user_id")
    List<Book> findFavoritesForUser(@Param("user_id") final int userId);

    @Query("SELECT b FROM Book b "
            + "JOIN b.users user "
            + "WHERE user.login = :login")
    List<Book> findFavoritesForUser(@Param("login") final String login);

    boolean existsAllByIdAndUsersContains(final int bookId, final User user);
}