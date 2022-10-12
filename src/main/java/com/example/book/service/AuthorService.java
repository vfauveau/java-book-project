package com.example.book.service;

import com.example.book.repository.entity.author.Author;
import com.example.book.repository.entity.author.AuthorRepository;
import com.example.book.repository.entity.book.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public AuthorService (BookRepository bookRepository1, AuthorRepository authorRepository1){
        this.bookRepository = bookRepository1;
        this.authorRepository = authorRepository1;
    }

    public List<Author> getAllAuthors(){
        return (List<Author>) this.authorRepository.findAll();
    }

    public void addAuthor(Author author){
        this.authorRepository.save(author);
    }
    public void checkIfAuthorExistsByLastName (String name){}

}
