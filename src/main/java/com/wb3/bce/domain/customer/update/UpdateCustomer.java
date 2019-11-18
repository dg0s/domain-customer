package com.wb3.bce.domain.customer.update;

import com.wb3.bce.domain.kernal.UseCase;
import com.wb3.bce.domain.customer.CustomerRequest;
import com.wb3.bce.domain.customer.Customer;
import com.wb3.bce.domain.customer.CustomerEntity;
import com.wb3.bce.domain.customer.CustomerGateway;

class UpdateCustomer implements UseCase {

    private CustomerRequest request;
    private CustomerGateway gateway;

    UpdateCustomer(CustomerRequest request, CustomerGateway gateway) {
        this.request = request;
        this.gateway = gateway;
    }

    public void execute() {
        CustomerEntity customer = new Customer(this.request);
        this.gateway.Update(customer);
    }
}
