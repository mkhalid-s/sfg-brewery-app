package com.bootstrap.microservice.sfgbrewery.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    /**
     * Customer Id.
     */
    private UUID id;

    /**
     * Customer Name.
     */
    private String name;

}
