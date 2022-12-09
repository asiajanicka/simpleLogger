package org.example.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat {
    private DateFormat() {
    }

    public static String format(LocalDateTime t) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return t.format(formatter);
    }

    public static String formatWithoutSpaces(LocalDateTime t) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM_HH-mm-ss");
        return t.format(formatter);
    }
}
