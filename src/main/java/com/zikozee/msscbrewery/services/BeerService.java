package com.zikozee.msscbrewery.services;

import com.zikozee.msscbrewery.web.model.BeerDto;

import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 27 April 2022
 */

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}
