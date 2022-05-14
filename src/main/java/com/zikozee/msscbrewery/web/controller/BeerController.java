package com.zikozee.msscbrewery.web.controller;

import com.zikozee.msscbrewery.services.BeerService;
import com.zikozee.msscbrewery.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 27 April 2022
 */

@Deprecated
@Slf4j
@RequestMapping(path = "api/v1/beer")
@RestController
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping(path = "{beerId}")
    public ResponseEntity<BeerDto>  getBeer(@PathVariable(value = "beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpHeaders> handlePost(@Valid @RequestBody BeerDto beerDto){
        BeerDto savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(path = "{beerId}")
    public ResponseEntity<HttpHeaders> handleUpdate(@PathVariable(value = "beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto){
        BeerDto savedDto = beerService.updateBeer(beerId, beerDto);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT );
    }

    @DeleteMapping(path = "{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable(value = "beerId") UUID beerId){
        beerService.deleteBeer(beerId);

    }
}
