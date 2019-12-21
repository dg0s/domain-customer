package com.wb3.domain.customer;

import com.wb3.domain.kernal.UseCaseRequestHandler;

public class RemoveCustomerUseCaseRequestHandler implements UseCaseRequestHandler<RemoveCustomerRequest> {

    private final CustomerGateway gateway;

    public RemoveCustomerUseCaseRequestHandler(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void Handle(RemoveCustomerRequest removeCustomerRequest) {
        new RemoveCustomer(removeCustomerRequest, this.gateway).execute();
    }
}
