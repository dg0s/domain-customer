package com.wb3.bce.domain.customer;

import com.wb3.bce.domain.kernal.UseCase;

class UpdateCustomer implements UseCase {

    private CustomerRequest request;
    private CustomerGateway gateway;

    UpdateCustomer(CustomerRequest request, CustomerGateway gateway) {
        this.request = request;
        this.gateway = gateway;
    }

    public void execute() {
        var customer = new Customer(this.request);
        this.gateway.Update(customer);
    }
}
