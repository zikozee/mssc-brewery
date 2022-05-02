package com.zikozee.msscbrewery.web.controller.v2;

import com.zikozee.msscbrewery.services.BeerServiceV2;
import com.zikozee.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 02 May 2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v2/beer")
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    @GetMapping(path = "{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable(value = "beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpHeaders> handlePost(@RequestBody BeerDtoV2 beerDto){
        BeerDtoV2 savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(path = "{beerId}")
    public ResponseEntity<HttpHeaders> handleUpdate(@PathVariable(value = "beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto){
        BeerDtoV2 savedDto = beerService.updateBeer(beerId, beerDto);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT );
    }

    @DeleteMapping(path = "{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable(value = "beerId") UUID beerId){
        beerService.deleteBeer(beerId);

    }
}
