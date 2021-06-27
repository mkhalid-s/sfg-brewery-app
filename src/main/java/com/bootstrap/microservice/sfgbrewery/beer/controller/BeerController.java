package com.bootstrap.microservice.sfgbrewery.beer.controller;

import com.bootstrap.microservice.sfgbrewery.beer.model.BeerDto;
import com.bootstrap.microservice.sfgbrewery.beer.service.BeerService;
import com.bootstrap.microservice.sfgbrewery.constants.UrlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequestMapping(UrlConstants.URL_BEER_API_MAIN_V1)
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping(value = "/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.findBeerByUuid(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> handlePost(BeerDto beerDto){
        Optional<BeerDto> savedBeerDto = Optional.ofNullable(beerService.createBeer(beerDto));

        if (savedBeerDto.isPresent()){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(URI.create(UrlConstants.URL_BEER_API_MAIN_V1+ "/"+savedBeerDto.get().getId().toString()));
            return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(BAD_REQUEST);
        }
    }

    @PutMapping( value = "/{beerId}")
    public ResponseEntity<BeerDto> updateBeer(BeerDto beerDto){
        beerService.updateBeer(beerDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping (value = "/{beerId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeer(beerId);
    }
}
