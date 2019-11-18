package com.wb3.bce.domain.customer;

public interface CustomerGateway {

    void Create(CustomerEntity customer);

    void Update(CustomerEntity customer);

    void Remove(CustomerEntity customer);
}
