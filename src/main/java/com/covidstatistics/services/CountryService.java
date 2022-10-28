package com.covidstatistics.services;

import com.covidstatistics.domain.entities.Country;

import java.util.List;

public interface CountryService {

    Country getCountryByCode(String code);

    void saveAll(List<Country> countries);

    long count();

    boolean exists(String countryCode);
}
