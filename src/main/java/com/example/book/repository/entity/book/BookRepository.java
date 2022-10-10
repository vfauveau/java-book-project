package com.example.book.repository.entity.book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE lower(b.name) LIKE lower(concat('%', :name,'%'))")
    List<Book> findBookByName(String name);

    @Query("SELECT b from Book b ORDER BY b.name asc ")
    List<Book> getBooksByName();
}
