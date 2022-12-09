package org.example.test;

import org.example.SeverityLevel;
import org.example.SimpleLogger;

public class Animal {
    private static final SimpleLogger logger = new SimpleLogger(Animal.class);

    public void printLog(){
        // add logging functions for all levels
        logger.writeLog(SeverityLevel.ERROR, "My log message from print");
    }

    public void printLogWithException(){
        try{
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e){
            // add logger.error(message, e)
            logger.writeLog(SeverityLevel.ERROR, "My log message from print with exception", e);
        }
    }
}