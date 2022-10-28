package com.covidstatistics.repository;

import com.covidstatistics.domain.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findAllByCountryCode(String countryCode);
}
