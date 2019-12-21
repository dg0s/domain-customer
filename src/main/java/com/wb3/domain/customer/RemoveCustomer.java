package com.wb3.domain.customer;

import com.wb3.domain.kernal.UseCase;

public class RemoveCustomer implements UseCase {

    private final RemoveCustomerRequest request;
    private final CustomerGateway gateway;

    public RemoveCustomer(RemoveCustomerRequest removeCustomerRequest, CustomerGateway gateway) {
        this.request = removeCustomerRequest;
        this.gateway = gateway;
    }

    @Override
    public void execute() {
        var customer = new Customer(request);
        this.gateway.Remove(customer);
    }
}
