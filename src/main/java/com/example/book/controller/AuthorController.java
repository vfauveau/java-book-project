package com.example.book.controller;

import com.example.book.repository.entity.author.Author;
import com.example.book.repository.entity.book.Book;
import com.example.book.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private AuthorService authorService;

    @GetMapping("/add")
    public void getCreateAuthor(Author author, Model model){

    }

    @PostMapping("/add")
    public void postCreateAuthor(Book book, Author author){
        authorService.addAuthor(author);
        book.getAuthor().add(author);

    }
}
