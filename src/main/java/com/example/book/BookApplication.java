package com.example.book;


import com.example.book.repository.entity.author.AuthorRepository;
import com.example.book.repository.entity.book.BookRepository;
import com.example.book.service.StorageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class BookApplication {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    private StorageService storageService;
    public BookApplication (BookRepository bookRepository1, AuthorRepository authorRepository1, StorageService service){
        this.bookRepository = bookRepository1;
        this.authorRepository = authorRepository1;
        this.storageService = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

}
