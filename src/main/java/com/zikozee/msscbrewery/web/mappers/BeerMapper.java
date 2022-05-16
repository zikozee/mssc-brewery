package com.zikozee.msscbrewery.web.mappers;

import com.zikozee.msscbrewery.domain.Beer;
import com.zikozee.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * @author: Ezekiel Eromosei
 * @created: 16 May 2022
 */

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
