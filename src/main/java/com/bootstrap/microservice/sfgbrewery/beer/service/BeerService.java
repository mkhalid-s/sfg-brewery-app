package com.bootstrap.microservice.sfgbrewery.beer.service;

import com.bootstrap.microservice.sfgbrewery.beer.model.BeerDto;

import java.util.List;
import java.util.UUID;


public interface BeerService {

    BeerDto findBeerByUuid(UUID beerId);

    BeerDto createBeer(BeerDto beerDto);

    BeerDto updateBeer(BeerDto beerDto);

    void deleteBeer(UUID beerId);
}
