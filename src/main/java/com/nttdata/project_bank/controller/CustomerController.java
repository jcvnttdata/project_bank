package com.nttdata.project_bank.controller;

import com.nttdata.project_bank.modelo.Customer;
import com.nttdata.project_bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Mono<Customer>> findById(@PathVariable("id") Integer id){
        Mono<Customer> monoCustomer = customerService.findByCustomerId(id);
        return new ResponseEntity<Mono<Customer>>(monoCustomer,monoCustomer != null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Mono<Customer>> updateCustomerById(@PathVariable("id") Integer id, @RequestBody Customer customer){
        Mono<Customer> customerMono = customerService.updateCustomer(id, customer);
        return new ResponseEntity<Mono<Customer>>(customerMono,customerMono != null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> deleteCustomerById(@PathVariable("id") Integer id){
        return customerService.deleteCustomer(id);
    }
}
