package com.example.HW6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Hw6Application {

    private static BookService bookService;

	public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Hw6Application.class, args);
        bookService = applicationContext.getBean(BookService.class);
	}

}
