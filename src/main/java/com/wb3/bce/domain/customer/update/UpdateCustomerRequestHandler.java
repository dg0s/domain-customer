package com.wb3.bce.domain.customer.update;

import com.wb3.bce.domain.kernal.RequestHandler;
import com.wb3.bce.domain.customer.CustomerGateway;

public class UpdateCustomerRequestHandler implements RequestHandler<UpdateCustomerRequest> {

    private final CustomerGateway gateway;

    public UpdateCustomerRequestHandler(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void Handle(UpdateCustomerRequest updateCustomerRequest) {
        new UpdateCustomer(updateCustomerRequest, this.gateway).execute();
    }


}
