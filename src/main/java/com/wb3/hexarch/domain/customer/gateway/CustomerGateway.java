package com.wb3.hexarch.domain.customer.gateway;

import com.wb3.hexarch.domain.customer.entity.CustomerEntity;

public interface CustomerGateway {

    void Create(CustomerEntity customer);

    void Update(CustomerEntity customer);
}
