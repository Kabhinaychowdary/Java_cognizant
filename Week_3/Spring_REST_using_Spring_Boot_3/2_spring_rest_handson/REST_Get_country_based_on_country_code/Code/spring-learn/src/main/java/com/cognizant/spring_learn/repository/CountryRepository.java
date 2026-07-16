package com.cognizant.spring_learn.repository;

import java.util.List;

import com.cognizant.spring_learn.Country;

public class CountryRepository {

    private final List<Country> countries;

    public CountryRepository(List<Country> countries) {
        this.countries = countries;
    }

    public Country findCountryByCode(String code) {
        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }
        return null;
    }

}