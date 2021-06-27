package com.bootstrap.microservice.sfgbrewery.beer;

import com.bootstrap.microservice.sfgbrewery.beer.controller.BeerController;
import com.bootstrap.microservice.sfgbrewery.beer.model.BeerDto;
import com.bootstrap.microservice.sfgbrewery.beer.service.BeerService;
import com.bootstrap.microservice.sfgbrewery.constants.UrlConstants;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
public class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BeerService beerService;

    @Autowired
    private BeerController beerController;

    BeerDto validBeerDto;

    @BeforeTestMethod
    public void setValidBeerDto(){
        validBeerDto = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Kingfisher")
                .beerStyle("Pale")
                .upc(123467890L)
                .build();
    }

    @Test
    public void getBeer() throws Exception {
        Mockito.when(beerService.findBeerByUuid(ArgumentMatchers.any(UUID.class))).thenReturn(validBeerDto);

        mockMvc.perform(MockMvcRequestBuilders.
                get(UrlConstants.URL_BEER_API_MAIN_V1+"/"+validBeerDto.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("$.id" , validBeerDto.getId().toString()));

    }
}
