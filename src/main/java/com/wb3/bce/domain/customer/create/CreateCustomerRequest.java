package com.wb3.bce.domain.customer.create;

import com.wb3.bce.domain.customer.CustomerRequest;

public class CreateCustomerRequest extends CustomerRequest {
    public CreateCustomerRequest(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
