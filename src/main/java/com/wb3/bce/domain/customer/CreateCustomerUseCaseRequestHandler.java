package com.wb3.bce.domain.customer;

import com.wb3.bce.domain.kernal.UseCaseRequestHandler;

public class CreateCustomerUseCaseRequestHandler implements UseCaseRequestHandler<CreateCustomerRequest> {

    private final CustomerGateway gateway;

    public CreateCustomerUseCaseRequestHandler(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void Handle(CreateCustomerRequest createCustomerRequest) {
        new CreateCustomer(createCustomerRequest, this.gateway).execute();
    }

}
