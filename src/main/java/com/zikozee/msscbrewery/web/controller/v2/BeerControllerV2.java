package com.zikozee.msscbrewery.web.controller.v2;

import com.zikozee.msscbrewery.services.BeerServiceV2;
import com.zikozee.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: Ezekiel Eromosei
 * @created: 02 May 2022
 */

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v2/beer")
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    @GetMapping(path = "{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable(value = "beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpHeaders> handlePost(@Valid @RequestBody BeerDtoV2 beerDto){
        BeerDtoV2 savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(path = "{beerId}")
    public ResponseEntity<HttpHeaders> handleUpdate(@PathVariable(value = "beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto){
        BeerDtoV2 savedDto = beerService.updateBeer(beerId, beerDto);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT );
    }

    @DeleteMapping(path = "{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable(value = "beerId") UUID beerId){
        beerService.deleteBeer(beerId);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<?>> validationErrorHandler(ConstraintViolationException ex){
        List<String> errors = new ArrayList<>(ex.getConstraintViolations().size());

        ex.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
