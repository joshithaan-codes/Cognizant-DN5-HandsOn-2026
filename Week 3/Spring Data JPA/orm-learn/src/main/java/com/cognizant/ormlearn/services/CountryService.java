package com.cognizant.ormlearn.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.entity.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.services.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode)
            throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found");
        }

        Country country = result.get();

        return country;
    }
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }
    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(code);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found");
        }

        Country country = result.get();
        country.setName(name);

        countryRepository.save(country);
    }
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
}