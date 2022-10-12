package com.example.book.repository.entity.author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    /*
    * addBookAuthor
    * addAuthorToBook
    * editBookAuthor
    * deleteBookAuthor
    * */
}
