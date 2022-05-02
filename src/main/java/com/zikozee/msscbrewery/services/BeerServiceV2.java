package com.zikozee.msscbrewery.services;

import com.zikozee.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 02 May 2022
 */

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

    BeerDtoV2 updateBeer(UUID beerId, BeerDtoV2 beerDto);

    void deleteBeer(UUID beerId);
}
