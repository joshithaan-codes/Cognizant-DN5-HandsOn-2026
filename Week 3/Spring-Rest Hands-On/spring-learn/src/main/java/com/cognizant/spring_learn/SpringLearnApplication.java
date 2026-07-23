package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws Exception {

		SpringApplication.run(SpringLearnApplication.class, args);

		displayDate();

		displayCountry();

		displayCountries();
	}

	// Hands-on 2
	public static void displayDate() throws Exception {

		LOGGER.info("START");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("date-format.xml");

		SimpleDateFormat format =
				context.getBean("dateFormat", SimpleDateFormat.class);

		Date date = format.parse("31/12/2018");

		LOGGER.debug("{}", date);

		LOGGER.info("END");
	}

	// Hands-on 4 & 5
	public static void displayCountry() {

		LOGGER.info("START");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");

		Country country =
				context.getBean("in", Country.class);

		Country anotherCountry =
				context.getBean("in", Country.class);

		LOGGER.debug("Country : {}", country);

		LOGGER.info("END");
	}

	// Hands-on 6
	@SuppressWarnings("unchecked")
	public static void displayCountries() {

		LOGGER.info("START");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");

		List<Country> countryList =
				(List<Country>) context.getBean("countryList");

		LOGGER.debug("Countries : {}", countryList);

		LOGGER.info("END");
	}
}