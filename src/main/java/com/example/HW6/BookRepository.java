package com.example.HW6;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookRepository {

    private final EntityManager entityManager;

    @Transactional
    public List<Book> findAll() {
        return entityManager.createNamedQuery(Book.FIND_ALL, Book.class).getResultList();
    }

    @Transactional
    public Book save(Book book) {
        return entityManager.merge(book);
    }

    @Transactional
    public List<Book> findByTitle(String title) {
        return entityManager.createNamedQuery(Book.FIND_ALL_BY_TITLE, Book.class).setParameter("title", title).getResultList();
    }

    @Transactional
    public Book findByID(int id) {
        return entityManager.find(Book.class, id);
    }

}
