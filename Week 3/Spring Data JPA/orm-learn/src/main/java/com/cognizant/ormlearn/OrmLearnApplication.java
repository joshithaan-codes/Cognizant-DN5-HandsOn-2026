package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.entity.Country;
import com.cognizant.ormlearn.services.CountryService;
import com.cognizant.ormlearn.services.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    private final CountryService countryService;

    public OrmLearnApplication(CountryService countryService) {
        this.countryService = countryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        getCountryTest();

        // testAddCountry();      // Hands-on 7
        // testUpdateCountry();   // Hands-on 8

        testDeleteCountry();      // Hands-on 9
    }

    // Hands-on 6
    private void getCountryTest() throws CountryNotFoundException {

        LOGGER.info("Start");

        Country country = countryService.findCountryByCode("IN");

        LOGGER.info("Country : {}", country);

        LOGGER.info("End");
    }

    // Hands-on 7
    private void testAddCountry() throws CountryNotFoundException {

        LOGGER.info("Start");

        Country country = new Country();
        country.setCode("ZZ");
        country.setName("New Land");

        countryService.addCountry(country);

        Country result = countryService.findCountryByCode("ZZ");

        LOGGER.info("Country : {}", result);

        LOGGER.info("End");
    }
    private void testUpdateCountry() throws CountryNotFoundException {

        LOGGER.info("Start");

        countryService.updateCountry("ZZ", "Spring Land");

        Country country = countryService.findCountryByCode("ZZ");

        LOGGER.info("Country : {}", country);

        LOGGER.info("End");
    }

    private void testDeleteCountry() throws CountryNotFoundException {

        LOGGER.info("Start");

        countryService.deleteCountry("ZZ");

        try {
            Country country = countryService.findCountryByCode("ZZ");
            LOGGER.info("Country : {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.info("Country deleted successfully.");
        }

        LOGGER.info("End");
    }
}