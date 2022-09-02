package com.amin.dev.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L,
                        "JohnnyBoy"),
                new Customer(2L,
                        "Charlie")
        );
    }
}
