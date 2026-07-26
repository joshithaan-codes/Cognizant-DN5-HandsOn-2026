package com.cognizant._springresthandson.controller;

import com.cognizant._springresthandson.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {

        LOGGER.info("START - addCountry");
        LOGGER.info("Country: {}", country);

        return country;
    }
}