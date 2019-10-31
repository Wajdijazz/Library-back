package com.libraryapplication.library.Book;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByIsbn(@Param("isbn")String isbn);
    List<Book> findByTitleContaining(String title);

}
