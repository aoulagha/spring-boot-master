package com.amin.dev.customer;

import com.amin.dev.customer.exception.CustomerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    List<Customer> getCustomers() {
        LOGGER.info("Getting the " +
                "customer List");
        List<Customer> customers =
                repository.findAll();
        return customers;
    }

    Customer getCustomer(final Long idCustomer) {
        LOGGER.info("Get the customer" +
                " {}", idCustomer);
        return repository.findById(idCustomer)
                .orElseThrow(() -> {
                    CustomerNotFoundException customerNotFoundException = new CustomerNotFoundException(
                            "Customer with Id " + idCustomer + " Not Found...");
                    LOGGER.error("Error in calling get Customer {}", idCustomer, customerNotFoundException);
                    return customerNotFoundException;
                });
    }
}
