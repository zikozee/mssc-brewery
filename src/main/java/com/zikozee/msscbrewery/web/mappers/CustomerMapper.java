package com.zikozee.msscbrewery.web.mappers;

import com.zikozee.msscbrewery.domain.Customer;
import com.zikozee.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

/**
 * @author: Ezekiel Eromosei
 * @created: 16 May 2022
 */

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);
}
