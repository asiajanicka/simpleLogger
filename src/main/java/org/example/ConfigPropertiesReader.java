package org.example;

import java.util.ResourceBundle;

public class ConfigPropertiesReader {
    //    Not allow to create an object of class
    private ConfigPropertiesReader() {
    }

    //Connecting to config file
    public static String getProperties(String key) {
        return ResourceBundle.getBundle("config").getString(key);
    }

    //Getting filename for logs
    public static String getFilename() {
        return getProperties("filename");
    }

    //Choosing severitylevel for logger
    public static SeverityLevel getSeverityLevel() {
        if (getProperties("severityLevel").isBlank()) {
            return SeverityLevel.TRACE;
        } else
            return SeverityLevel.valueOf(getProperties("severityLevel").toUpperCase());
    }

    //Choosing output type for logs
    public static OutputType getOutputType() {
        if (getProperties("output").isBlank()) {
            return OutputType.CONSOLE;
        } else
            return OutputType.valueOf(getProperties("output").toUpperCase());
    }
}
