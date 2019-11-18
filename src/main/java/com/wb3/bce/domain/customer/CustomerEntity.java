package com.wb3.bce.domain.customer;

import com.wb3.bce.domain.kernal.Identity;

import java.util.UUID;

public abstract class CustomerEntity {

    private Identity id;
    private String firstName;
    private String lastName;

    public CustomerEntity(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.id = new Identity();
    }

    protected void setId(Identity id) {
        this.id = id;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UUID getId() {
        return this.id.get();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

}
