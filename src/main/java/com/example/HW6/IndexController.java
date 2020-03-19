package com.example.HW6;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final BookService bookService;

    @RequestMapping({ "/", "" })
    public String index(final Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String addBook(@ModelAttribute final Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/book/{id}")
    public String findByID(@PathVariable int id, Model model) {
        Book book = bookService.findByID(id);
        model.addAttribute("book", book);
        return "book";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String findByTitleOrIsbn(final Model model, @RequestParam final String string) {
        List<Book> books = bookService.findByTitleOrIsbn(string);
        model.addAttribute("books", books);
        return "books";
    }


}



