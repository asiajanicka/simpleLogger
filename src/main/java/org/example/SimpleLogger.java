package org.example;

import org.example.utils.DateFormat;
import org.example.writers.ILogWrite;
import org.example.writers.ToConsoleWriter;
import org.example.writers.ToLogFileWriter;

import java.time.LocalDateTime;

public class SimpleLogger {
    private ILogWrite logWriter;
    private String className;

    public SimpleLogger() {
        logWriter = getLogWriter();
    }

    public SimpleLogger(Class className) {
        this.className = className.toString();
        logWriter = getLogWriter();
    }

    private ILogWrite getLogWriter() {
        switch (ConfigPropertiesReader.getOutputType()) {
            case FILE: {
                return ToLogFileWriter.getInstance();
            }
            default: {
                return ToConsoleWriter.getInstance();
            }
        }
    }

    private String formatLog(SeverityLevel level, String message) {
        return String.format("%s %S %s %s",
                DateFormat.format(LocalDateTime.now()), level, className, message);
    }

    public void writeLog(SeverityLevel actualLevel, String message) {
        // add severity level validation
        logWriter.write(formatLog(actualLevel, message));
    }

    public void writeLog(SeverityLevel actualLevel, String message, Throwable t) {
        // add severity level validation
        logWriter.write(formatLog(actualLevel, message), t);
    }
}
