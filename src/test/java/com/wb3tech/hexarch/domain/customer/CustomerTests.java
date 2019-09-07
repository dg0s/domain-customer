package com.wb3tech.hexarch.domain.customer;

import com.wb3.hexarch.domain.customer.usecase.CreateCustomer;
import com.wb3.hexarch.domain.customer.entity.CustomerEntity;
import com.wb3.hexarch.domain.customer.gateway.CustomerGateway;
import com.wb3.hexarch.domain.customer.boundary.CustomerRequest;
import com.wb3.hexarch.domain.customer.usecase.UpdateCustomer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CustomerTests {

    @Test
    // Given the need to create a new customer
    // When I supply the first name as "Bill"
    //  and the last name as "Bensing"
    // Then a customer should be created with a valid UUID
    //  and the first name shall be "Bill"
    //  and the last name shall be "Bensing"
    //  and the CustomerGateway.Create(...) must be invoked
    void CreateCustomer() {

        CustomerRequest request = new CustomerTestRequest("Bill", "Bensing");
        CustomerGatewaySpy gateway = new CustomerGatewaySpy();
        new CreateCustomer(request, gateway).execute();

        Assertions.assertNotNull(request.getId());
        Assertions.assertEquals("Bill", request.getFirstName());
        Assertions.assertEquals("Bensing", request.getLastName());
        Assertions.assertTrue(gateway.CreateWasCalled());
    }

    @Test
    // Given the need to update an existing customer
    // When the customer id is "bbe2ee9e-dda1-4d24-92c2-91e35ea55a49"
    //  and the first name is changed to "Billy"
    //  and the last name is changed to "Bensing III"
    // Then the customer should be updated with a first name of "Billy"
    //  and the a last name of "Bensing III"
    //  and the CustomerGateway.Update(...) must be invoked
    void UpdateCustomer() {

        UUID customerId = UUID.fromString("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49");
        CustomerRequest updateCustomer = new CustomerTestRequest(customerId, "Billy", "Bensing III");
        CustomerGatewaySpy gateway = new CustomerGatewaySpy();
        new UpdateCustomer(updateCustomer, gateway).execute();

        Assertions.assertEquals("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49", updateCustomer.getId().toString());
        Assertions.assertEquals("Billy", updateCustomer.getFirstName());
        Assertions.assertEquals("Bensing III", updateCustomer.getLastName());
        Assertions.assertTrue(gateway.UpdateWasCalled());

    }

}

class CustomerTestRequest extends CustomerRequest {
    CustomerTestRequest(String fistName, String lastName) {
        super(fistName, lastName);
    }
    CustomerTestRequest(UUID id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}

class CustomerGatewaySpy implements CustomerGateway {

    private boolean createWasCalled;
    private boolean updateWasCalled;

    boolean CreateWasCalled() {
        return this.createWasCalled;
    }
    boolean UpdateWasCalled() {
        return this.updateWasCalled;
    }

    public void Create(CustomerEntity customer) {
        this.createWasCalled = true;
    }

    public void Update(CustomerEntity customer) {
        this.updateWasCalled = true;
    }
}