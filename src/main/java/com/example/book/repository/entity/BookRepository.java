package com.example.book.repository.entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends  CrudRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE lower(b.name) LIKE lower(concat('%', :name,'%'))")
    List<Book> findBookByName(String name);
}
