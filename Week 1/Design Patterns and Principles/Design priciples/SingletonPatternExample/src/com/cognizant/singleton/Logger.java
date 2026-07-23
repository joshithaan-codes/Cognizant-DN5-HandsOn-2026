package com.cognizant.singleton;

public class Logger {

    // Step 1: Create a single instance of Logger
    private static Logger instance;

    // Step 2: Private constructor
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 3: Method to return the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Step 4: Logging method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}