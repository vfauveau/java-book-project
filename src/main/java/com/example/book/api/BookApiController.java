package com.example.book.api;

import com.example.book.controller.BookDTO;
import com.example.book.repository.entity.book.Book;
import com.example.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookApiController extends BaseApiController {

    BookService bookService;
    public BookApiController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<Book> booklist = this.bookService.getAllBooks();
        List<BookDTO> bookDTOList = booklist.stream().map(book -> {
            return BookDTO.from(book);
        }).collect(Collectors.toList());

        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);    }

}
