package com.wb3.domain.kernal;

import java.util.UUID;

public class Identity {

    private UUID id;

    public Identity() {
        this.id = UUID.randomUUID();
    }

    Identity(UUID id) {
        this.id = id;
    }

    public UUID get() {
        return this.id;
    }

    public static Identity Of(UUID id) {
        return new Identity(id);
    }

    public boolean isValid()  {
        return this.id != null;
    }

    public boolean isInvalid()  {
        return !this.isValid();
    }

    public boolean equals(Identity identity) {
        return this.id == identity.get();
    }
}
