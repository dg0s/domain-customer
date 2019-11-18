package com.wb3.bce.domain.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

@DisplayName("Customer Use Cases")
class CustomerTests {

    private CustomerGatewaySpy gateway;

    @BeforeEach
    void setup() {
        this.gateway = new CustomerGatewaySpy();
    }

    @Test
    @DisplayName("Create Customer")
    // Given the need to create a new customer
    // When I supply the first name as "Bill"
    //  and the last name as "Bensing"
    // Then a customer should be created with a valid UUID
    //  and the first name shall be "Bill"
    //  and the last name shall be "Bensing"
    //  and the CustomerGateway.Create(...) must be invoked
    void CreateCustomer() {

        var request = new CreateCustomerRequest("Bill", "Bensing");
        var handler = new CreateCustomerUseCaseRequestHandler(this.gateway);

        handler.Handle(request);

        Assertions.assertNotNull(request.getId());
        Assertions.assertEquals("Bill", request.getFirstName());
        Assertions.assertEquals("Bensing", request.getLastName());
        Assertions.assertTrue(this.gateway.CreateWasCalled());
    }

    @Test
    @DisplayName("Update Customer")
    // Given the need to update an existing customer
    // When the customer id is "bbe2ee9e-dda1-4d24-92c2-91e35ea55a49"
    //  and the first name is changed to "Billy"
    //  and the last name is changed to "Bensing III"
    // Then the customer should be updated with a first name of "Billy"
    //  and the a last name of "Bensing III"
    //  and the CustomerGateway.Update(...) must be invoked
    void UpdateCustomer() {

        var request = new UpdateCustomerRequest(UUID.fromString("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49"), "Billy", "Bensing III");
        var handler = new UpdateCustomerUseCaseRequestHandler(this.gateway);

        handler.Handle(request);

        Assertions.assertEquals("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49", request.getId().toString());
        Assertions.assertEquals("Billy", request.getFirstName());
        Assertions.assertEquals("Bensing III", request.getLastName());
        Assertions.assertTrue(this.gateway.UpdateWasCalled());

    }

    @Test
    @DisplayName("Remove Customer")
        // Given the need to update an existing customer
        // When the customer id is "bbe2ee9e-dda1-4d24-92c2-91e35ea55a49"
        //  and the first name is changed to "Billy"
        //  and the last name is changed to "Bensing III"
        // Then the customer should be updated with a first name of "Billy"
        //  and the a last name of "Bensing III"
        //  and the CustomerGateway.Update(...) must be invoked
    void RemoveCustomer() {

        var request = new RemoveCustomerRequest(UUID.fromString("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49"));
        var handler = new RemoveCustomerUseCaseRequestHandler(this.gateway);

        handler.Handle(request);

        Assertions.assertTrue(this.gateway.RemoveWasCalled());

    }
}