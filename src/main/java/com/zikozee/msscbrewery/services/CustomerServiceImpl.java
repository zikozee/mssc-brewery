package com.zikozee.msscbrewery.services;

import com.zikozee.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 27 April 2022
 */

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Ezekiel")
                .build();
    }
}
