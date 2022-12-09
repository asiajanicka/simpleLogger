package org.example.test;

import org.example.SimpleLogger;

public class TestLogger {
    private static final SimpleLogger logger = new SimpleLogger(TestLogger.class);

    public static void main(String[] args) {
        // add some logging function from main


        // generate test logs from Animal class
        Animal animal = new Animal();
        animal.printLog();
        animal.printLogWithException();

        // generate test logs from Cat class
        Cat cat = new Cat();
        cat.printLog();
        cat.printLogWithException();
    }
}
