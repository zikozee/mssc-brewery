package com.zikozee.msscbrewery.services;

import com.zikozee.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 27 April 2022
 */

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);

    void deleteById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);
}
