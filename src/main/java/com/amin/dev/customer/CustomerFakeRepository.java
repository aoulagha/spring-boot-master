package com.amin.dev.customer;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        Clock cl = Clock.systemUTC();

        return Arrays.asList(
                new Customer(1L,
                        "JohnnyBoy",
                        "jb2908",
                        "testmail@gmail.com", LocalDate.now(cl)),
                new Customer(2L,
                        "Charlie",
                        "cl2908", "testmail@gmail.com", LocalDate.now(cl))
        );
    }
}
