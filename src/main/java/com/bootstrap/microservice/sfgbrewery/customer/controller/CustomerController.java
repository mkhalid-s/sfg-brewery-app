package com.bootstrap.microservice.sfgbrewery.customer.controller;

import com.bootstrap.microservice.sfgbrewery.beer.model.BeerDto;
import com.bootstrap.microservice.sfgbrewery.constants.UrlConstants;
import com.bootstrap.microservice.sfgbrewery.customer.model.CustomerDto;
import com.bootstrap.microservice.sfgbrewery.customer.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequestMapping(UrlConstants.URL_CUST_API_MAIN_V1)
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{custId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("custId") UUID custId){
        return new ResponseEntity<CustomerDto>(customerService.getCustomerById(custId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> handlePost(CustomerDto customerDto){
        Optional<CustomerDto> savedcustomerDto = Optional.ofNullable(customerService.createCustomer(customerDto));

        if (savedcustomerDto.isPresent()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(URI.create(UrlConstants.URL_CUST_API_MAIN_V1+ "/"+savedcustomerDto.get().getId().toString()));
            return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(BAD_REQUEST);
        }
    }

    @PutMapping( value = "/{custId}")
    public ResponseEntity<BeerDto> updateCustomer(CustomerDto customerDto){
        customerService.updateCustomer(customerDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping (value = "/{custId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteCustomer(@PathVariable("custId") UUID custId){
        customerService.deleteCustomer(custId);
    }
}
