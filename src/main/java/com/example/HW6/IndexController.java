package com.example.HW6;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final BookRepository bookRepository;

    @RequestMapping({ "/", "" })
    public String index(final Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String addBook(@ModelAttribute final Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/book/{id}")
    public String findByID(Model model, @PathVariable int id) {
        Book book = bookRepository.findByID(id);
        model.addAttribute("book", book);
        return "book";
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String findByTitle(Model model, @RequestParam String title) {
        List<Book> books = bookRepository.findByTitle(title);
        model.addAttribute("books", books);
        return "books";
    }

    @RequestMapping(value = "/book1", method = RequestMethod.GET)
    public String findByIsbn(Model model, @RequestParam String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        model.addAttribute("book", book);
        return "book";
    }

}



