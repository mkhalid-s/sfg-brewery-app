package com.bootstrap.microservice.sfgbrewery.customer.service;

import com.bootstrap.microservice.sfgbrewery.customer.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID custId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Tom Hanks")
                .build();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(customerDto.getName())
                .build();
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .build();
    }

    @Override
    public void deleteCustomer(UUID custId) {
        System.out.println("Deleting Customer "+custId);
    }


}
