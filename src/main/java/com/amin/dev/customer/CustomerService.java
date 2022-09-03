package com.amin.dev.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

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

    Customer getCustomer(final Long idCustomer) {
        Predicate<Customer> customerPredicate = customer -> customer.getId() == idCustomer;
        return getCustomers().stream()
                .filter(customerPredicate)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));
    }
}
