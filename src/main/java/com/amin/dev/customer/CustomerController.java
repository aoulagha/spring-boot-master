package com.amin.dev.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1" +
        "/customer")
@Deprecated
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping(value = "all")
    List<Customer> getCustomer() {
        return service.getCustomers();
    }

    @PostMapping
    void createCustomer(@RequestBody Customer customer) {
        System.out.println("Creating " +
                "request - " +
                "new customer ... " + customer);
    }

    @DeleteMapping(path =
            "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long customerId) {
        System.out.println("Deleting " +
                "request - " +
                "customer with Id ..." +
                " " + customerId);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("Updating " +
                "request - " +
                "customer ... " + customer);
    }
}
