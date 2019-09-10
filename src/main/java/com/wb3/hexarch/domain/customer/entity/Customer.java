package com.wb3.hexarch.domain.customer.entity;


import com.wb3.hexarch.domain.Identity;
import com.wb3.hexarch.domain.customer.boundary.CustomerRequest;

public class Customer extends CustomerEntity {

    public Customer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Customer(CustomerRequest request) {
        super(request.getFirstName(), request.getLastName());
        this.setId(new Identity(request.getId()));
    }

}
