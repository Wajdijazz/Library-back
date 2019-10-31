package com.libraryapplication.library.Book;

import java.util.List;

public interface IBookService {

     public List<Book> getBookByIsbn(String isbn);
     public    List<Book> getBookByTitle(String title);
     public Book updateBook(Long id, Book book);
     public Long deleteBook(Long id);
     public Book addBook(Book book);




}
