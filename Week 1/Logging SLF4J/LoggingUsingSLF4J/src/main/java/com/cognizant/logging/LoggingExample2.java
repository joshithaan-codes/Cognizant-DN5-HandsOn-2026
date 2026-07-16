package com.cognizant.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample2 {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingExample2.class);

    public static void main(String[] args) {

        String name = "Joshitha";
        int age = 20;
        String department = "Information Technology";

        logger.info("Student Name: {}", name);
        logger.info("Age: {}", age);
        logger.info("Department: {}", department);

        logger.info("{} is {} years old and belongs to {}.", name, age, department);
    }
}