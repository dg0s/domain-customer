package com.wb3.bce.domain.customer.update;

import com.wb3.bce.domain.kernal.UseCaseRequestHandler;
import com.wb3.bce.domain.customer.CustomerGateway;

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
