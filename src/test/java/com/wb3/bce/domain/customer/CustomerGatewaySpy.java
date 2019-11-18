package com.wb3.bce.domain.customer;

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