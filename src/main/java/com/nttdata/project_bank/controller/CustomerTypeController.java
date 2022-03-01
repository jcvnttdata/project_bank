package com.nttdata.project_bank.controller;

import com.nttdata.project_bank.modelo.Customer;
import com.nttdata.project_bank.modelo.CustomerType;
import com.nttdata.project_bank.service.CustomerService;
import com.nttdata.project_bank.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerTypeController {

    @Autowired
    private CustomerTypeService customerTypeService;

    @PostMapping("/createType/customertype")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CustomerType customerType){
        customerTypeService.createCustomerType(customerType);
    }

    @GetMapping(value = "/getType/all_customer_type", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<CustomerType> findAll(){
        return customerTypeService.findAllCustomerType();
    }

    @GetMapping("/getType/{id}")
    @ResponseBody
    public ResponseEntity<Mono<CustomerType>> findById(@PathVariable("id") Integer id){
        Mono<CustomerType> monoCustomerType = customerTypeService.findByCustomerTypeId(id);
        return new ResponseEntity<Mono<CustomerType>>(monoCustomerType,monoCustomerType != null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateType/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Mono<CustomerType>> updateCustomerById(@PathVariable("id") Integer id, @RequestBody CustomerType customerType){
        Mono<CustomerType> customerMono = customerTypeService.updateCustomerType(id, customerType);
        return new ResponseEntity<Mono<CustomerType>>(customerMono,customerMono != null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteType/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> deleteCustomerById(@PathVariable("id") Integer id){
        return customerTypeService.deleteCustomerType(id);
    }
}
