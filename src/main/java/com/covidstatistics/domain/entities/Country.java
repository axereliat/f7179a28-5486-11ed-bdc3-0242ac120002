package com.covidstatistics.domain.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "countries")
@Data
public class Country {

    @Id
    private String id;

    private String country;

    private String countryCode;

    private String slug;

    private Long newConfirmed;

    private Long totalConfirmed;

    private Long newDeaths;

    private Long totalDeaths;

    private Long newRecovered;

    private Long totalRecovered;

    private LocalDateTime date;
}
