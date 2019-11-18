package com.wb3.bce.domain.customer;


import com.wb3.bce.domain.kernal.Identity;

public class Customer extends CustomerEntity {

    public Customer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Customer(CustomerRequest request) {
        super(request.getFirstName(), request.getLastName());
        this.setId(Identity.Of(request.getId()));
    }

}
