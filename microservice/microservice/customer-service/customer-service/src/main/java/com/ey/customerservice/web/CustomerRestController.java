package com.ey.customerservice.web;

import com.ey.customerservice.entities.Customer;
import com.ey.customerservice.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {
    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    public List<Customer> customerList(){
        return this.customerRepository.findAll();    }

    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        return this.customerRepository.findById(id).get();
    }



}