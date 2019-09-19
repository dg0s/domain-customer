package com.wb3.bce.domain.customer.control;

import com.wb3.bce.domain.Usecase;
import com.wb3.bce.domain.customer.entity.Customer;
import com.wb3.bce.domain.customer.entity.CustomerEntity;
import com.wb3.bce.domain.customer.gateway.CustomerGateway;
import com.wb3.bce.domain.customer.boundary.CustomerRequest;

public class CreateCustomer implements Usecase {

    private CustomerRequest request;
    private CustomerGateway customerGateway;

    public CreateCustomer(CustomerRequest request, CustomerGateway customerGateway) {
        this.request = request;
        this.customerGateway = customerGateway;
    }

    public void execute() {
        CustomerEntity customer = new Customer(this.request.getFirstName(), this.request.getLastName());
        this.customerGateway.Create(customer);
        this.request.setId(customer.getId());
    }

}
