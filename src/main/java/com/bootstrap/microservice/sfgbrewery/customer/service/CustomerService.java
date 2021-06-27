package com.bootstrap.microservice.sfgbrewery.customer.service;

import com.bootstrap.microservice.sfgbrewery.customer.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    public CustomerDto getCustomerById(UUID custId);

    public CustomerDto createCustomer(CustomerDto customerDto);

    public CustomerDto updateCustomer(CustomerDto customerDto);

    void deleteCustomer(UUID custId);

}
