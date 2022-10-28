package com.covidstatistics.services;

import com.covidstatistics.domain.entities.Country;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DatabaseInitializerServiceImpl implements DatabaseInitializerService {

    private static final String COUNTRIES_MAP_KEY = "Countries";

    private final CountryService countryService;

    public DatabaseInitializerServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostConstruct
    @Override
    public void init() {
        if (this.countryService.count() > 0) {
            return;
        }

        RestTemplate restTemplate = new RestTemplate();
        ModelMapper modelMapper = new ModelMapper();

        Map<String, Object> responseEntity =
                restTemplate.getForEntity("https://api.covid19api.com/summary", Map.class).getBody();

        List<Object> countriesObj = (List<Object>) responseEntity.get(COUNTRIES_MAP_KEY);
        List<Country> countries = new ArrayList<>();

        for (Object obj : countriesObj) {
            Country country = modelMapper.map(obj, Country.class);

            countries.add(country);
        }
        this.countryService.saveAll(countries);
    }
}
