package com.nttdata.project_bank.service;

import com.nttdata.project_bank.modelo.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    void createCustomer(Customer e);
    Mono<Customer> findByCustomerId(Integer id);
    Flux<Customer> findAllCustomer();
    Mono<Customer> updateCustomer(Integer id,Customer e);
    Mono<Void> deleteCustomer(Integer id);
}
