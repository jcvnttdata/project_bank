package com.nttdata.project_bank.service;

import com.nttdata.project_bank.modelo.Customer;
import com.nttdata.project_bank.modelo.CustomerType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerTypeService {

    void createCustomerType(CustomerType e);
    Mono<CustomerType> findByCustomerTypeId(Integer id);
    Flux<CustomerType> findAllCustomerType();
    Mono<CustomerType> updateCustomerType(Integer id,CustomerType e);
    Mono<Void> deleteCustomerType(Integer id);
}
