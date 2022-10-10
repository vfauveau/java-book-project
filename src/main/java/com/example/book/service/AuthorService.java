package com.example.book.service;

import com.example.book.repository.entity.author.Author;
import com.example.book.repository.entity.author.AuthorRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return (List<Author>) this.authorRepository.findAll();
    }
}
