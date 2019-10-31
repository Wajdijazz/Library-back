package com.libraryapplication.library.Customer;

import com.libraryapplication.library.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface  CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmail(@Param("email")String email);
    List<Customer> findByLastNameContaining(String lastName);




}
