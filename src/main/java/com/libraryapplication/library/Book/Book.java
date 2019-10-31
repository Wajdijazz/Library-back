package com.libraryapplication.library.Book ;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.libraryapplication.library.Category.Category;
import com.libraryapplication.library.Customer.Customer;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "ISBN", nullable = false, unique = true)
    private String isbn;




    @Column(name = "TOTAL_EXAMPLARIES")
    private Integer totalExamplaries;



    @Column(name = "author")
    private String author;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;



 /*   @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
   @JoinTable(name = "Book_Customer",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "Customer_id") })
    private Set<Customer> customers = new HashSet<>();

*/
    public Book() {
        super();
    }

    public Book(String title, String isbn, Integer totalExamplaries, String author, Category category) {
        this.title = title;
        this.isbn = isbn;
        this.totalExamplaries = totalExamplaries;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }



    public Integer getTotalExamplaries() {
        return totalExamplaries;
    }

    public void setTotalExamplaries(Integer totalExamplaries) {
        this.totalExamplaries = totalExamplaries;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

   public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
/*
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }*/
}
