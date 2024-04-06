package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeHelper {
    public static LocalDateTime parseDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy h:mm:ss a", Locale.ENGLISH);
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        return dateTime.format(outputFormatter);

    }
}
