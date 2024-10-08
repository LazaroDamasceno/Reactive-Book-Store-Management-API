package com.api.v1.utils.customer;

import com.api.v1.exceptions.customer.DuplicatedSsnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.v1.domain.entities.Customer;
import com.api.v1.domain.repositories.CustomerRepository;

import reactor.core.publisher.Mono;

@Component
public class CustomerFinderUtil {

    @Autowired
    private CustomerRepository repository;

    public Mono<Customer> find(String ssn) {
        return repository
            .findAll()
            .filter(e -> e.getSsn().equals(ssn))
            .singleOrEmpty()
            .switchIfEmpty(Mono.error(new DuplicatedSsnException(ssn)));
    }
    
}

