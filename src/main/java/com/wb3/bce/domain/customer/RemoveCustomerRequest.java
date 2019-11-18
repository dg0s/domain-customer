package com.wb3.bce.domain.customer;

import com.wb3.bce.domain.kernal.Identity;

import java.util.UUID;

public class RemoveCustomerRequest extends CustomerRequest {

    private Identity identity;

    public RemoveCustomerRequest(UUID uuid) {
        super();
        this.identity = Identity.Of(uuid);
    }

    Identity getIdentity() {
        return this.identity;
    }
}
