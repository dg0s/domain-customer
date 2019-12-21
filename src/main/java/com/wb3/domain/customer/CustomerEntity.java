package com.wb3.domain.customer;

import com.wb3.domain.kernal.Identity;

public interface CustomerEntity {

    Identity getId();
    String getFirstName();
    String getLastName();

    boolean equals(CustomerEntity entity);

}
