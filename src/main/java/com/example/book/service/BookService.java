package com.example.book.service;

import com.example.book.exceptions.BookNotFoundException;
import com.example.book.repository.entity.book.Book;
import com.example.book.repository.entity.book.BookRepository;
import com.example.book.repository.entity.book.CreateBook;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
    public void addBook (CreateBook book){
        Book book1 = book.toBook();
        this.bookRepository.save(book1);
    }

    public void editBook(Long id, Book newBook){
        Book book = this.bookRepository.findById(id).get();
        book = newBook;
        this.bookRepository.save(book);
    }
    public void deleteBook (long id){
        this.bookRepository.deleteById(id);
    }
}