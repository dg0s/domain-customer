package com.wb3.bce.domain.customer;

import com.wb3.bce.domain.kernal.Identity;

class Customer extends CustomerEntity {

    Customer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    Customer(CustomerRequest request) {
        this(request.getFirstName(), request.getLastName());
        this.setId(Identity.Of(request.getId()));
    }

}
