package com.nttdata.project_bank.repository;

import com.nttdata.project_bank.modelo.CustomerType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends ReactiveMongoRepository<CustomerType,Integer> {
}
