package com.amin.dev.customer;

import com.amin.dev.customer.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    List<Customer> getCustomers() {
        List<Customer> customers =
                repository.findAll();
        return customers;
    }

    Customer getCustomer(final Long idCustomer) {
        return repository.findById(idCustomer)
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer with Id " + idCustomer + " Not Found...")
                );
    }
}
