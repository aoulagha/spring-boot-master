package com.amin.dev.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Primary
public class CustomerRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        // todo - connect to real
        //  Database
        return Collections.singletonList(
                new Customer(1L,
                        "ToDo. " +
                                "Implement Real DB")
        );
    }
}
