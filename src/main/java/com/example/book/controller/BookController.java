package com.example.book.controller;

import com.example.book.repository.entity.author.Author;
import com.example.book.repository.entity.book.Book;
import com.example.book.repository.entity.book.CreateBook;
import com.example.book.service.AuthorService;
import com.example.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;
    private AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
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
            List<Book> bookList = bookService.getAllBooksOrderedByName();
            model.addAttribute("books", bookList);
        }
        return "bookListView";
    }


    @GetMapping(path = "/details/{id}")
    public String findBookById(Model model, @PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookDetails";
    }

    @GetMapping("/add")
    public String getaddBookForm(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "bookAdd";
    }

    @PostMapping("/add")
    public RedirectView addBook(CreateBook createBook){
        bookService.addBook(createBook);
        return new RedirectView("/books/all");
    }

    @PostMapping("/details/{id}/delete")
    public RedirectView deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return new RedirectView("/books/all");
    }

    @GetMapping("/edit/{id}")
    public String getEditBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookEdit";
    }

    @PostMapping("/edit/{id}")
    public RedirectView postEditBook(@PathVariable("id") Long id, Book newBook) {
        bookService.editBook(id, newBook);
        return new RedirectView("/books/details/{id}");
    }
}
