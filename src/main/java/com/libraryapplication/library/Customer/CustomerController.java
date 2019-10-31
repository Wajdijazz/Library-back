package com.libraryapplication.library.Customer;


import com.libraryapplication.library.Book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Map;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping()
public class CustomerController {

    /**
     *
     */
    @Autowired
    private  CustomerRepository  customerRepository;


    @Transactional
    @GetMapping("/customerByEmail/{email}")
    public Object findCustomerByEmail(@PathVariable(value = "email") String email)
    {
        return customerRepository.findByEmail(email);

    }

    @GetMapping("/customerByLastName/{lastName}")
    public Object getCustomerByLastNameContaining(@PathVariable(value = "lastName") String lastName)
    {
        return customerRepository.findByLastNameContaining(lastName);

    }

    @DeleteMapping("/customerDelete/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long id)
    {
        customerRepository.deleteById(id);
        return null;


    }

    @Transactional
    @PutMapping("/customerUpdate/{id}")
    public Object updateCustomer(@PathVariable(value = "id") Long id, @RequestBody Customer customer)
    {
        Customer CustomerUp=customerRepository.getOne(id);
        CustomerUp.setAddress(customer.getAddress());
        CustomerUp.setEmail(customer.getEmail());
        CustomerUp.setFirstName(customer.getFirstName());

        CustomerUp.setJob(customer.getJob());
        customerRepository.save(CustomerUp);
        return CustomerUp;
    }


}
