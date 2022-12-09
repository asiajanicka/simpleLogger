package org.example.writers;

import org.example.ConfigPropertiesReader;
import org.example.utils.DateFormat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ToLogFileWriter implements ILogWrite {
    private static ToLogFileWriter instance = null;

    private ToLogFileWriter() {
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
    public void write(String text) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(getFileName(), true)))) {
            out.println(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(String text, Throwable t) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(getFileName(), true)))) {
            out.println(text);
            t.printStackTrace(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
