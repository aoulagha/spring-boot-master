package com.amin.dev.customer;

import com.amin.dev.customer.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping(path = "api/v2" +
        "/customers")
public class CustomerControllerV2 {

    private final CustomerService service;

    @Autowired
    public CustomerControllerV2(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    List<Customer> getCustomers() {
        return service.getCustomers();
    }

    @GetMapping(path =
            "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long customerId) {
        return service.getCustomer(customerId);
    }

    @GetMapping(path =
            "{customerId}/exception")
    void getCustomerException(@PathVariable("customerId") Long customerId) {
        throw new ApiRequestException(
                "ApiRequestExceptionFor " + customerId
        );
    }

    @PostMapping
    void createCustomer(@Valid @RequestBody Customer customer) {
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
