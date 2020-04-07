package com.example.HW6;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @Autowired
    private final BookService bookService;

    @RequestMapping({ "/", "" })
    public String index(final Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "index";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute final Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/book/{id}")
    public String findByID(Model model, @PathVariable int id) {
        Book book = bookService.findByID(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/book")
    public String findByTitleOrIsbn(Model model, @RequestParam String string) {
        List<Book> books = bookService.findByTitleOrIsbn(string);
        model.addAttribute("books", books);
        return "books";
    }


}



