package com.amin.dev.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Customer {

    private final Long id;
    private final String name;

    private final String password;

    private final LocalDate createDt;

    public Customer(Long id, String name, String password, LocalDate createDt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.createDt = createDt;
    }

    @JsonProperty("customerId")
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonFormat(pattern="dd-MM-yyyy")
    public LocalDate getCreateDt() {
        return createDt;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", createDt=" + createDt +
                '}';
    }
}
