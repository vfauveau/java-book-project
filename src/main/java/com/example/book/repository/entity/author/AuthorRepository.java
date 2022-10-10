package com.example.book.repository.entity.author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    /*
    * addBookAuthor
    * addAuthorToBook
    * editBookAuthor
    * deleteBookAuthor
    * */
}
