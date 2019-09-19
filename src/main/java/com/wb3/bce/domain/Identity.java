package com.wb3.bce.domain;

import java.util.UUID;

public class Identity {

    private UUID id;

    public Identity() {
        this.id = UUID.randomUUID();
    }

    public Identity(UUID id) {
        this.id = id;
    }

    public UUID get() {
        return this.id;
    }
}
