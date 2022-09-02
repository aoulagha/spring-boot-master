package com.amin.dev.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo repository;

    public CustomerService(CustomerRepo repository) {
        this.repository = repository;
    }

    List<Customer> getCustomers() {
        List<Customer> customers =
                repository.getCustomers();
        return customers;
    }
}
