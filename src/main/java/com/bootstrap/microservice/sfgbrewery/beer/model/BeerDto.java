package com.bootstrap.microservice.sfgbrewery.beer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    /**
     * Beer id
     */
    private UUID id;

    /**
     * Beer name.
     */
    private String beerName;

    /**
     * Beer style.
     */
    private String beerStyle;

    /**
     * UPC.
     */
    private Long upc;
}
