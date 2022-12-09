package org.example.test;

import org.example.SeverityLevel;
import org.example.SimpleLogger;

public class Animal {
    private static final SimpleLogger logger = new SimpleLogger(Animal.class);

    public void printLog() {
        // add logging functions for all levels
        logger.fatal("FATAL: My log message from print");
        logger.error("ERROR: My log message from print");
        logger.warn("WARNING: My log message from print");
        logger.info("INFO: My log message from print");
        logger.debug("DEBUG MODE: My log message from print");
    }

    public void printLogWithException() {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            logger.error("My log message from print with exception", e);
        }
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            logger.warn("My log message from print with exception", e);
        }

    }
}
