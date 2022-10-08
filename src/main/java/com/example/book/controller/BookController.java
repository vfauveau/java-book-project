package com.example.book.controller;

import com.example.book.repository.entity.Book;
import com.example.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /*
@GetMapping("/all")
public String displayAllBooks(Model model) {
    List<Book> bookList = bookService.getAllBooks();
    model.addAttribute("books", bookList);
    return "bookListView";
}

@RequestMapping(value = "/search-book", method = RequestMethod.POST)
public String searchBookByName(Model model, @RequestParam("search-book") String name) {
    List<Book> bookList = bookService.findBookByName(name);
    model.addAttribute("books", bookList);
    return "bookListView";
}
*/
    @GetMapping(value = {"/all", "/"})
    public String displayAllBooks(Model model, @RequestParam(value = "search", required = false) String name) {
        if (name != null) {
            List<Book> bookList = bookService.findBookByName(name);
            model.addAttribute("books", bookList);
        } else {
            List<Book> bookList = bookService.getAllBooks();
            model.addAttribute("books", bookList);
        }
        return "bookListView";
    }


    @GetMapping(path = "/details/{id}")
    public String findCustomerById(Model model, @PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "details";
    }

    @GetMapping("/add")
    public String getaddBookForm() {
        return "bookAdd";
    }

    @PostMapping("/add")
    public RedirectView addBook(@ModelAttribute("book") Book book) {
        bookService.createBook(book);
        return new RedirectView("/books/all");
    }


    @PostMapping("/details/{id}/delete")
    public RedirectView deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return new RedirectView("/books/all");
    }
}
