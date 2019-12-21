package com.wb3.domain.customer;

import com.wb3.domain.kernal.UseCase;

public class CreateCustomer implements UseCase {

    private CustomerRequest request;
    private CustomerGateway customerGateway;

    CreateCustomer(CustomerRequest request, CustomerGateway customerGateway) {
        this.request = request;
        this.customerGateway = customerGateway;
    }

    public void execute() {
        var customer = new Customer(this.request.getFirstName(), this.request.getLastName());
        this.customerGateway.Create(customer);
        this.request.setId(customer.getId().get());
    }

}
