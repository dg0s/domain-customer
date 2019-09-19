package com.wb3.bce.domain.customer.boundary;

import java.util.UUID;

public abstract class CustomerRequest {

    private UUID id;
    private String firstName;
    private String lastName;

    public CustomerRequest(String fistName, String lastName) {
        this.firstName = fistName;
        this.lastName = lastName;
    }

    public CustomerRequest(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
