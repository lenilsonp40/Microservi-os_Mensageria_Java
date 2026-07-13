package com.lenilson.hexagonal.aplication.ports.out;

import com.lenilson.hexagonal.aplication.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
