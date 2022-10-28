package com.covidstatistics.services;

import com.covidstatistics.domain.entities.Country;
import com.covidstatistics.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getCountriesByCode(String code) {
        return this.countryRepository.findAllByCountryCode(code);
    }

    @Override
    public void saveAll(List<Country> countries) {
        this.countryRepository.saveAll(countries);
    }

    @Override
    public long count() {
        return this.countryRepository.count();
    }


}
