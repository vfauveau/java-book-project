package com.example.book.service;

import com.example.book.exceptions.BookNotFoundException;
import com.example.book.repository.entity.author.Author;
import com.example.book.repository.entity.author.AuthorRepository;
import com.example.book.repository.entity.book.Book;
import com.example.book.repository.entity.book.BookRepository;
import com.example.book.repository.entity.book.CreateBook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private StorageService storageService;

    public BookService(BookRepository bookRepository1, AuthorRepository authorRepository1 , StorageService storageService) {
        this.bookRepository = bookRepository1;
        this.authorRepository = authorRepository1;
        this.storageService = storageService;
    }

    public List<Book> getAllBooks() {
        return (List<Book>) this.bookRepository.findAll();
    }

    public List<Book> getAllBooksOrderedByName() {
        return this.bookRepository.getBooksByName();
    }

    public Book getBookById(long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public List<Book> findBookByName(String name) {
        return this.bookRepository.findBookByName(name);
    }

    public void addBook(CreateBook book) {

        List<Long> authorsId = book.getAuthorId();
        List<Author> authorList = (List<Author>) authorRepository.findAllById(authorsId);
        Book b = new Book();

        b.setName(book.getName());
        b.setPrice(book.getPrice());
        b.setRating(book.getRating());
        b.setPictureUrl(book.getPictureUrl());
        b.setPublishingDate(book.getPublishingDate());
        b.setSummary(book.getSummary());
        b.setAuthor(authorList);

        MultipartFile picture = book.getPictureFile();
        if(picture == null){
            b.setPictureUrl(book.getPictureUrl());
        }else{
            storageService.store(picture);
            b.setPictureUrl("http://localhost:8080/images/" + picture.getOriginalFilename());
        }
        this.bookRepository.save(b);
    }

    public void editBook(Long id, Book newBook) {
        Book book = this.bookRepository.findById(id).get();
        book = newBook;
        this.bookRepository.save(book);
    }

    public void deleteBook(long id) {
        this.bookRepository.deleteById(id);
    }
}