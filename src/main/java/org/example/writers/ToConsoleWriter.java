package org.example.writers;

import java.io.PrintStream;

public class ToConsoleWriter implements ILogWrite {
    private static ToConsoleWriter instance = null;
    private PrintStream out;

    private ToConsoleWriter() {
        out = System.out;
    }

    public static ToConsoleWriter getInstance() {
        if (instance == null) instance = new ToConsoleWriter();
        return (instance);
    }

    @Override
    public void write(String message) {
        out.println(message);
    }

    @Override
    public void write(String message, Throwable e) {
        out.println(message);
        e.printStackTrace(out);
    }
}
