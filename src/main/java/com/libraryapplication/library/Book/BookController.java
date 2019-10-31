package com.libraryapplication.library.Book;


import com.libraryapplication.library.Category.Category;
import com.libraryapplication.library.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping()
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Transactional
    @GetMapping("/booksByIsbn/{isbn}")
    public Object findBookByIsbn(@PathVariable(value = "isbn") String isbn)
    {
        return bookService.getBookByIsbn(isbn);

    }
    @GetMapping("/booksByTitle/{title}")
    public Object getBookByTitleContaining(@PathVariable(value = "title") String title)
    {
        return bookService.getBookByTitle(title);

    }
    @Transactional
    @PutMapping("/bookUpdate/{id}")
    public Object updateBook(@PathVariable(value = "id") Long id, @RequestBody Book book)
    {
        return bookService.updateBook(id,book);
    }

    @DeleteMapping("/bookDelete/{id}")
    public Object deleteBook(@PathVariable(value = "id") Long id)
    {
        return bookService.deleteBook(id);
    }


    @PostMapping("/category/{categoryId}/book")
    public Book createBook(@PathVariable (value = "categoryId") Long categoryId,
                                 @Valid @RequestBody Book book) {
        return categoryRepository.findById(categoryId).map(category -> {
            book.setCategory(category);
            return bookService.addBook(book);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + categoryId + " not found"));
    }

}
