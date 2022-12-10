package org.example.test;

import org.example.SimpleLogger;

public class TestLogger {
    private static final SimpleLogger logger = new SimpleLogger(TestLogger.class);

    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.printLog();
        animal.printLogWithException();

        Cat cat = new Cat();
        cat.printLog();
        cat.printLogWithException();
        logger.fatal("DEBUG: from TestLogger");
        logger.error("ERROR: from TestLogger");
        logger.info("INFO: from TestLogger");
        logger.debug("DEBUG: from TestLogger");
        logger.debug("LAST LOGGER MESSAGE IN PROGRAM");
    }
}
