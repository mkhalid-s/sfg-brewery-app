package com.bootstrap.microservice.sfgbrewery.beer.service;

import com.bootstrap.microservice.sfgbrewery.beer.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImp implements BeerService {
    @Override
    public BeerDto findBeerByUuid(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Heineken")
                .beerStyle("Strong")
                .build();
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc())
                .build();
    }

    @Override
    public BeerDto updateBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(beerDto.getId())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc())
                .build();
    }

    @Override
    public void deleteBeer(UUID beerId) {
        System.out.println("Deleting "+beerId);
    }
}
