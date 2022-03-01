package com.nttdata.project_bank.repository;

import com.nttdata.project_bank.modelo.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends ReactiveMongoRepository<Customer, Integer> {
}
