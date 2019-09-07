package com.wb3.hexarch.domain.customer.entity;

import com.wb3.hexarch.domain.Identity;
import com.wb3.hexarch.domain.customer.boundary.CustomerRequest;

import java.util.UUID;

public class Customer implements CustomerEntity {

    private Identity id;
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.id = new Identity();
    }

    public Customer(CustomerRequest request) {
        this.id = new Identity(request.getId());
        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UUID getId() {
        return this.id.get();
    }

    public String getFirstName() {
        return this.lastName;
    }

    public String getLastName() {
        return this.firstName;
    }

}
