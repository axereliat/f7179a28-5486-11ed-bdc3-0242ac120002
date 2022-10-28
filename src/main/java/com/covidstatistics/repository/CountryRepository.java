package com.covidstatistics.repository;

import com.covidstatistics.domain.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    Country findByCountryCode(String countryCode);

    boolean existsByCountryCode(String countryCode);
}
