package com.covidstatistics.services;

import com.covidstatistics.domain.entities.Country;

import java.util.List;

public interface CountryService {

    List<Country> getCountriesByCode(String code);

    void saveAll(List<Country> countries);
}
