package com.wb3.bce.domain.customer.create;

import com.wb3.bce.domain.kernal.RequestHandler;
import com.wb3.bce.domain.customer.CustomerGateway;

public class CreateCustomerRequestHandler implements RequestHandler<CreateCustomerRequest> {

    private final CustomerGateway gateway;

    public CreateCustomerRequestHandler(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void Handle(CreateCustomerRequest createCustomerRequest) {
        new CreateCustomer(createCustomerRequest, this.gateway).execute();
    }

}
