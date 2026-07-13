package com.lenilson.hexagonal.aplication.ports.out;

import com.lenilson.hexagonal.aplication.core.domain.Address;

public interface FindAdressByZipCodeOutputPort {

    Address find(String zipCode);
}
