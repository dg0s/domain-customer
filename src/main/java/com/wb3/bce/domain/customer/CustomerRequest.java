package com.wb3.bce.domain.customer;

import java.util.UUID;

public abstract class CustomerRequest {

    private UUID id;
    private String firstName;
    private String lastName;

    public CustomerRequest(String fistName, String lastName) {
        this.firstName = fistName;
        this.lastName = lastName;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

}
