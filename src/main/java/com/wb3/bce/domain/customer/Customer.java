package com.wb3.bce.domain.customer;

import com.wb3.bce.domain.kernal.Entity;
import com.wb3.bce.domain.kernal.Identity;

class Customer extends Entity implements CustomerEntity   {

    private String firstName;
    private String lastName;

    Customer(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.assignNewIdentity();
    }

    Customer(Identity identity, String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(identity);
    }

    Customer(CustomerRequest request) {
        this(Identity.Of(request.getId()), request.getFirstName(), request.getLastName());
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public boolean equals(CustomerEntity entity) {
        var id = this.getId().equals(entity.getId());
        var firstName = this.firstName.equals(entity.getFirstName());
        var lastName = this.lastName.equals(entity.getLastName());
        return id && firstName && lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = applyStringDefaults(lastName);
    }

    private void setFirstName(String firstName) {
        this.firstName = applyStringDefaults(firstName);
    }

}
