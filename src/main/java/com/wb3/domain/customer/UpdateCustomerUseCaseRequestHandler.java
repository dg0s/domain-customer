package com.wb3.domain.customer;

import com.wb3.domain.kernal.UseCaseRequestHandler;

public class UpdateCustomerUseCaseRequestHandler implements UseCaseRequestHandler<UpdateCustomerRequest> {

    private final CustomerGateway gateway;

    public UpdateCustomerUseCaseRequestHandler(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void Handle(UpdateCustomerRequest updateCustomerRequest) {
        new UpdateCustomer(updateCustomerRequest, this.gateway).execute();
    }


}
