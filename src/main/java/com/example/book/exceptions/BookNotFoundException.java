package com.example.book.exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(long id){
        super("Book with " + id + "not found in database");
    }
}
