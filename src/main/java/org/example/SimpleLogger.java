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

    private void writeLog(SeverityLevel actualLevel, String message) {
        if (validateLevel(actualLevel)) {
            logWriter.write(formatLog(actualLevel, message));
        }
    }

    private void writeLog(SeverityLevel actualLevel, String message, Throwable t) {
        if (validateLevel(actualLevel)) {
            logWriter.write(formatLog(actualLevel, message), t);
        }
    }

    private boolean validateLevel(SeverityLevel actualLevel) {
        return actualLevel.getValue() <= ConfigPropertiesReader.getSeverityLevel().getValue();
    }

    public void fatal(String message) {
        writeLog(SeverityLevel.FATAL, message);
    }

    public void fatal(String message, Throwable t) {
        writeLog(SeverityLevel.FATAL, message, t);
    }

    public void error(String message) {
        writeLog(SeverityLevel.ERROR, message);
    }

    public void error(String message, Throwable t) {
        writeLog(SeverityLevel.ERROR, message, t);
    }

    public void warn(String message) {
        writeLog(SeverityLevel.WARN, message);
    }

    public void warn(String message, Throwable t) {
        writeLog(SeverityLevel.WARN, message, t);
    }

    public void info(String message) {
        writeLog(SeverityLevel.INFO, message);
    }

    public void info(String message, Throwable t) {
        writeLog(SeverityLevel.INFO, message, t);
    }

    public void debug(String message) {
        writeLog(SeverityLevel.DEBUG, message);
    }

    public void debug(String message, Throwable t) {
        writeLog(SeverityLevel.DEBUG, message, t);
    }

    public void trace(String message) {
        writeLog(SeverityLevel.TRACE, message);
    }

    public void trace(String message, Throwable t) {
        writeLog(SeverityLevel.TRACE, message, t);
    }
}
