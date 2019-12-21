package com.wb3.bce.domain.kernal;

public abstract class Entity {

    private Identity id;

    protected void setId(Identity id) {
        if (id == null) { throw new NullPointerException("The identity is null."); }
        if (id.isInvalid()) { throw new IllegalArgumentException("The identity is not valid."); }
        this.id = id;
    }

    public Identity getId() {
        return this.id;
    }

    protected void assignNewIdentity() {
        this.id = new Identity();
    }

    protected String applyStringDefaults(String string) {
        return  string == null ? "" : string.trim();
    }

}
