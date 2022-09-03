package com.amin.dev.customer;

import org.springframework.stereotype.Repository;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Repository
public class CustomerRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        // todo - connect to real
        //  Database
        Clock cl = Clock.systemUTC();
        return Collections.singletonList(
                new Customer(1L,
                        "ToDo. " +
                                "Implement Real DB", "myPasswordHello", "testmail@gmail.com", LocalDate.now(cl))
        );
    }
}
