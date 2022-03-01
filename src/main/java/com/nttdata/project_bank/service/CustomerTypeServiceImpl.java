package com.nttdata.project_bank.service;

import com.nttdata.project_bank.modelo.CustomerType;
import com.nttdata.project_bank.repository.CustomerRepository;
import com.nttdata.project_bank.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService{

    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public void createCustomerType(CustomerType e) {
        customerTypeRepository.save(e).subscribe();
    }

    @Override
    public Mono<CustomerType> findByCustomerTypeId(Integer id) {
        return customerTypeRepository.findById(id);
    }

    @Override
    public Flux<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Mono<CustomerType> updateCustomerType(Integer id, CustomerType e) {
        return customerTypeRepository.save(e);
    }

    @Override
    public Mono<Void> deleteCustomerType(Integer id) {
        return customerTypeRepository.deleteById(id);
    }
}
