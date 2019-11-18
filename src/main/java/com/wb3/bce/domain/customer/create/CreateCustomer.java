package com.wb3.bce.domain.customer.create;

import com.wb3.bce.domain.kernal.UseCase;
import com.wb3.bce.domain.customer.Customer;
import com.wb3.bce.domain.customer.CustomerEntity;
import com.wb3.bce.domain.customer.CustomerGateway;
import com.wb3.bce.domain.customer.CustomerRequest;

public class CreateCustomer implements UseCase {

    private CustomerRequest request;
    private CustomerGateway customerGateway;

    CreateCustomer(CustomerRequest request, CustomerGateway customerGateway) {
        this.request = request;
        this.customerGateway = customerGateway;
    }
    public void execute() {
        CustomerEntity customer = new Customer(this.request.getFirstName(), this.request.getLastName());
        this.customerGateway.Create(customer);
        this.request.setId(customer.getId());
    }

}
