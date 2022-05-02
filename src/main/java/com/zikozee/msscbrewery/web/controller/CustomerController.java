package com.zikozee.msscbrewery.web.controller;

import com.zikozee.msscbrewery.services.CustomerService;
import com.zikozee.msscbrewery.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 27 April 2022
 */

@RequestMapping(path = "api/v1/customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(path = "{customerId}")
    public ResponseEntity<CustomerDto> getBeer(@PathVariable(value = "customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
}