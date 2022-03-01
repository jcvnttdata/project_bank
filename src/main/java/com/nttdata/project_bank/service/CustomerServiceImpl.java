package com.nttdata.project_bank.service;

import com.nttdata.project_bank.modelo.Customer;
import com.nttdata.project_bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void createCustomer(Customer e) {
        customerRepository.save(e).subscribe();
    }

    @Override
    public Mono<Customer> findByCustomerId(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Flux<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> updateCustomer(Integer id, Customer e) {
        return customerRepository.save(e);
    }

    @Override
    public Mono<Void> deleteCustomer(Integer id) {
        return customerRepository.deleteById(id);
    }
}
