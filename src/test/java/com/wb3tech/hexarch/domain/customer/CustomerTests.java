package com.wb3tech.hexarch.domain.customer;

import com.wb3.bce.domain.UsecaseHandler;
import com.wb3.bce.domain.customer.control.CreateCustomer;
import com.wb3.bce.domain.customer.entity.CustomerEntity;
import com.wb3.bce.domain.customer.gateway.CustomerGateway;
import com.wb3.bce.domain.customer.boundary.CustomerRequest;
import com.wb3.bce.domain.customer.control.UpdateCustomer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

@DisplayName("Customer Use Cases")
class CustomerTests {

    private UsecaseHandler usecaseHandler;
    private CustomerGatewaySpy gateway;

    @BeforeEach
    void setup() {
        this.usecaseHandler = new UsecaseHandler();
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

        CustomerRequest request = new CustomerTestRequest("Bill", "Bensing");

        this.usecaseHandler.Invoke(new CreateCustomer(request, this.gateway));

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

        UUID customerId = UUID.fromString("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49");
        CustomerRequest updateCustomer = new CustomerTestRequest(customerId, "Billy", "Bensing III");

        this.usecaseHandler.Invoke(new UpdateCustomer(updateCustomer, this.gateway));

        Assertions.assertEquals("bbe2ee9e-dda1-4d24-92c2-91e35ea55a49", updateCustomer.getId().toString());
        Assertions.assertEquals("Billy", updateCustomer.getFirstName());
        Assertions.assertEquals("Bensing III", updateCustomer.getLastName());
        Assertions.assertTrue(this.gateway.UpdateWasCalled());

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