package com.libraryapplication.library.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class BookService implements IBookService {

    @Autowired

    private BookRepository bookRepository;


    @Override
    public List<Book> getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book BookUp=bookRepository.getOne(id);
        BookUp.setAuthor(book.getAuthor());
        BookUp.setIsbn(book.getIsbn());
        BookUp.setTitle(book.getTitle());
        BookUp.setTotalExamplaries(book.getTotalExamplaries());
        bookRepository.save(BookUp);
        return BookUp;
    }

    @Override
    public Long deleteBook(Long id) {
        bookRepository.deleteById(id);
        return id;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }


}
