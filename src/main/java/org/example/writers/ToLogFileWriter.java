package org.example.writers;

import org.example.ConfigPropertiesReader;
import org.example.utils.DateFormat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class ToLogFileWriter implements ILogWrite {
    private static ToLogFileWriter instance = null;
    private PrintStream out;

    private ToLogFileWriter() {
        try {
            out = new PrintStream(new FileOutputStream(getFileName(), true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ToLogFileWriter getInstance() {
        if (instance == null) instance = new ToLogFileWriter();
        return (instance);
    }

    private String getFileName() {
        String name;
        if (!ConfigPropertiesReader.getFilename().isBlank()) {
            name = String.format("target/%s", ConfigPropertiesReader.getFilename());
        } else {
            name = String.format("target/logs_%s.logs", DateFormat.formatWithoutSpaces(LocalDateTime.now()));
        }
        return name;
    }

    @Override
    public void write(String message) {
        out.println(message);
    }

    @Override
    public void write(String message, Throwable t) {
        out.println(message);
        t.printStackTrace(out);
    }

    @Override
    protected void finalize() {
        out.close();
    }
}
