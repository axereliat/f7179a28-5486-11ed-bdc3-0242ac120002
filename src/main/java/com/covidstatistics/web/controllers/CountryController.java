package com.covidstatistics.web.controllers;

import com.covidstatistics.domain.entities.Country;
import com.covidstatistics.services.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/country/{countryCode}")
    public List<Country> getCountriesByCode(@PathVariable String countryCode) {
        return this.countryService.getCountriesByCode(countryCode);
    }
}
