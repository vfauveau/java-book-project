package com.example.book.controller;

import com.example.book.exceptions.BookNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "bookNotFound";

    @ExceptionHandler(value = BookNotFoundException.class)
    public String notFoundErrorHandler(Model model, Exception e){
        model.addAttribute("exception" , e);
        return DEFAULT_ERROR_VIEW;
    }
}
