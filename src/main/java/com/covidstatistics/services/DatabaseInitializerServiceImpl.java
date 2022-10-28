package com.covidstatistics.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class DatabaseInitializerServiceImpl implements DatabaseInitializerService {

    private static final String COUNTRIES_MAP_KEY = "countries";

    @Override
    public void init() {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> responseEntity =
                restTemplate.getForEntity("https://api.covid19api.com/summary", Map.class).getBody();

        var s = responseEntity.get(COUNTRIES_MAP_KEY);
        System.out.println();
    }
}
