package com.wb3.hexarch.domain.customer.control;

import com.wb3.hexarch.domain.UseCase;
import com.wb3.hexarch.domain.customer.boundary.CustomerRequest;
import com.wb3.hexarch.domain.customer.entity.Customer;
import com.wb3.hexarch.domain.customer.entity.CustomerEntity;
import com.wb3.hexarch.domain.customer.gateway.CustomerGateway;

public class UpdateCustomer implements UseCase {

    private CustomerRequest request;
    private CustomerGateway gateway;

    public UpdateCustomer(CustomerRequest request, CustomerGateway gateway) {
        this.request = request;
        this.gateway = gateway;
    }

    public void execute() {
        CustomerEntity customer = new Customer(this.request);
        this.gateway.Update(customer);
    }
}
