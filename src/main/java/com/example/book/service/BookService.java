package com.example.book.service;

import com.example.book.exceptions.BookNotFoundException;
import com.example.book.repository.entity.Book;
import com.example.book.repository.entity.BookRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Book getBookById(long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    /*
    public List<Book> getBookByName(String name) {
        List<Book> foundBooks = new ArrayList<>();
        List<Book> bookList = getAllBooks();

        for (Book book : bookList) {
            if (book.getName().toLowerCase().contains(name.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
*/

    public List<Book> findBookByName(String name) {
        return this.bookRepository.findBookByName(name);
    }
    public void createBook (Book book){
        this.bookRepository.save(book);
    }

    public void deleteBook (long id){
        this.bookRepository.deleteById(id);
    }
}
