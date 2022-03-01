package com.nttdata.project_bank.controller;

import com.nttdata.project_bank.modelo.Customer;
import com.nttdata.project_bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @GetMapping(value = "/get/all_customer", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Customer> findAll(){
        return customerService.findAllCustomer();
    }
}
