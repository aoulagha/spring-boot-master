package com.amin.dev.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("This " +
                    "is the load " +
                    "commandLine " +
                    "Runner with bean");
        };
    }

    @Bean
    @Primary
    CustomerRepo customerRepo() {
        System.out.println("customer " +
                "Fake repo used " + useFakeCustomerRepo);
        return useFakeCustomerRepo ?
                new CustomerFakeRepository() : new CustomerRepository();
    }
}
