package com.wb3.bce.domain.customer;

import com.wb3.bce.domain.kernal.Identity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Customer Entity")
public class CustomerEntityTests {

    @Test @DisplayName("Customer Identity - Null identity exception thrown")
    public void NullCustomerIdentity() {

        var customer = new CustomerEntityUnderTest("Bill", "Bensing");

        try {
            customer.setId(null);
        } catch (Exception ex) {
            Assertions.assertSame(ex.getClass(), NullPointerException.class);
            Assertions.assertSame(ex.getMessage(),"The identity is null.");
        }

    }

    @Test @DisplayName("Customer Identity - Invalid identity exception thrown")
    public void InvalidCustomerIdentity() {

        var customer = new CustomerEntityUnderTest("Bill", "Bensing");

        try {
            var id = Identity.Of(null);
            customer.setId(id);
        } catch (Exception ex) {
            Assertions.assertSame(ex.getClass(), IllegalArgumentException.class);
            Assertions.assertSame(ex.getMessage(),"The identity is not valid.");
        }

    }

    @Test @DisplayName("Customer Identity - Valid Identity")
    public void ValidCustomerIdentity() {

        var customer = new CustomerEntityUnderTest("Bill", "Bensing");
        var id = new Identity();
        customer.setId(id);

        Assertions.assertTrue(id.equals(customer.getId()));


    }

    @Test @DisplayName("First Name - Default to empty string when null is provided")
    public void EmptyStringFirstName() {

        var customer = new CustomerEntityUnderTest(null, "Bensing");
        Assertions.assertEquals(customer.getFirstName(), "");

    }

    @Test @DisplayName("First Name - Default to empty string when string with spaces is provided")
    public void FirstNameOnlySpaces() {

        var customer = new CustomerEntityUnderTest("     ", "Bensing");
        Assertions.assertEquals(customer.getFirstName(), "");

    }

    @Test @DisplayName("First Name - Trim Whitespace around first name")
    public void FirstNameWithLeadingAndTrailingWhitespace() {

        var customer = new CustomerEntityUnderTest(" Bill ", "Bensing");
        var id = new Identity();
        customer.setId(id);

        Assertions.assertEquals(customer.getFirstName(), "Bill");

    }

    @Test @DisplayName("Last Name - Default to empty string when null is provided")
    public void EmptyStringLastName() {

        var customer = new CustomerEntityUnderTest("Bill", null);
        Assertions.assertEquals(customer.getLastName(), "");

    }

    @Test @DisplayName("Last Name - Default to empty string when string with spaces is provided")
    public void LastNameOnlySpaces() {

        var customer = new CustomerEntityUnderTest("Bill", "   ");
        Assertions.assertEquals(customer.getLastName(), "");

    }

    @Test @DisplayName("Last Name - Trim Whitespace around last name")
    public void LAstNameWithLeadingAndTrailingWhitespace() {

        var customer = new CustomerEntityUnderTest(" Bill ", "   Bensing   ");
        Assertions.assertEquals(customer.getLastName(), "Bensing");

    }

}


class CustomerEntityUnderTest extends CustomerEntity {

    public CustomerEntityUnderTest(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
