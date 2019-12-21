package com.wb3.domain.customer;

import com.wb3.domain.kernal.Identity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Customer Entity")
public class CustomerEntityTests {

    @Test @DisplayName("Customer Identity - Null identity exception thrown")
    public void NullCustomerIdentity() {

        try {
            new Customer(null, "Bill", "Bensing");
        } catch (Exception ex) {
            Assertions.assertSame(ex.getClass(), NullPointerException.class);
            Assertions.assertSame(ex.getMessage(),"The identity is null.");
        }

    }

    @Test @DisplayName("Customer Identity - Invalid identity exception thrown")
    public void InvalidCustomerIdentity() {

        try {
            new Customer(Identity.Of(null), "Bill", "Bensing");
        } catch (Exception ex) {
            Assertions.assertSame(ex.getClass(), IllegalArgumentException.class);
            Assertions.assertSame(ex.getMessage(),"The identity is not valid.");
        }

    }

    @Test @DisplayName("Customer Identity - Valid Identity")
    public void ValidCustomerIdentity() {

        var id = new Identity();
        var customer = new Customer(id, "Bill", "Bensing");

        Assertions.assertTrue(id.equals(customer.getId()));


    }

    @Test @DisplayName("First Name - Default to empty string when null is provided")
    public void EmptyStringFirstName() {

        var customer = new Customer(null, "Bensing");
        Assertions.assertEquals(customer.getFirstName(), "");

    }

    @Test @DisplayName("First Name - Default to empty string when string with spaces is provided")
    public void FirstNameOnlySpaces() {

        var customer = new Customer("     ", "Bensing");
        Assertions.assertEquals(customer.getFirstName(), "");

    }

    @Test @DisplayName("First Name - Trim Whitespace around first name")
    public void FirstNameWithLeadingAndTrailingWhitespace() {

        var id = new Identity();
        var customer = new Customer(id, " Bill ", "Bensing");
        Assertions.assertEquals(customer.getFirstName(), "Bill");

    }

    @Test @DisplayName("Last Name - Default to empty string when null is provided")
    public void EmptyStringLastName() {

        var customer = new Customer("Bill", null);
        Assertions.assertEquals(customer.getLastName(), "");

    }

    @Test @DisplayName("Last Name - Default to empty string when string with spaces is provided")
    public void LastNameOnlySpaces() {

        var customer = new Customer("Bill", "   ");
        Assertions.assertEquals(customer.getLastName(), "");

    }

    @Test @DisplayName("Last Name - Trim Whitespace around last name")
    public void LastNameWithLeadingAndTrailingWhitespace() {

        var customer = new Customer(" Bill ", "   Bensing   ");
        Assertions.assertEquals(customer.getLastName(), "Bensing");

    }

    @Test @DisplayName("Customer Entity Equality - Identity does not match")
    public void CustomerEqualityIdentityMisMatch() {

        var customer1 = new Customer("Bill", "Bensing");
        var customer2 = new Customer("Bill", "Bensing");

        Assertions.assertNotEquals(customer1.getId(), customer2.getId());

    }

    @Test @DisplayName("Customer Entity Equality - First Name does not match")
    public void CustomerEqualityFirstNameMisMatch() {

        var customer1 = new Customer("Bill", "Bensing");
        var customer2 = new Customer("William", "Bensing");

        Assertions.assertNotEquals(customer1.getFirstName(), customer2.getFirstName());

    }

    @Test @DisplayName("Customer Entity Equality - Last Name does not match")
    public void CustomerEqualityLastNameMisMatch() {

        var customer1 = new Customer("Bill", "Bensing");
        var customer2 = new Customer("Bill", "Bensinger");

        Assertions.assertNotEquals(customer1.getLastName(), customer2.getLastName());

    }

    @Test @DisplayName("Customer Entity Equality - Both Entities are equal")
    public void CustomerEntitiesEqual() {

        var identity = new Identity();
        var customer1 = new Customer(identity, "Bill", "Bensing");
        var customer2 = new Customer(identity, "Bill", "Bensing");

        Assertions.assertTrue(customer1.equals(customer2));
    }

}
