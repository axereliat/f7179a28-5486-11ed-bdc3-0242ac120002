package com.covidstatistics.web.controllers;

import com.covidstatistics.dto.ResponseDto;
import com.covidstatistics.services.CountryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final String COUNTRY_NOT_FOUND_MESSAGE = "Country could not be found";
    private static final String LOWERCASE_NOT_ALLOWED = "Country code must be uppercase";

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/country/{countryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCountriesByCode(@PathVariable String countryCode) {
        if (!countryCode.toUpperCase().equals(countryCode)) {
            return ResponseEntity.status(400).body(new ResponseDto(LOWERCASE_NOT_ALLOWED));
        }
        if (!this.countryService.exists(countryCode)) {
            return ResponseEntity.status(404).body(new ResponseDto(COUNTRY_NOT_FOUND_MESSAGE));
        }

        return ResponseEntity.ok(this.countryService.getCountryByCode(countryCode));
    }
}
