package com.example.book.repository.entity.author;

import com.example.book.repository.entity.book.Book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Author  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authorList")
    private List<Book> hisBooks;
    private String firstName;
    private String lastName;
    public Author() {}

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public Author(List<Book> hisBooks, String firstName, String lastName) {
        this.hisBooks = hisBooks;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getHisBooks() {
        return hisBooks;
    }

    public void setHisBooks(List<Book> hisBooks) {
        this.hisBooks = hisBooks;
    }
}