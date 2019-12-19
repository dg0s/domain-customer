package com.wb3.bce.domain.customer;

import com.wb3.bce.domain.kernal.Identity;

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
        if (id == null) { throw new NullPointerException("The identity is null."); }
        if (id.isInvalid()) { throw new IllegalArgumentException("The identity is not valid."); }
        this.id = id;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName == null ? "" : lastName.trim();
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName == null ? "" : firstName.trim();
    }

    public Identity getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

}
