package se.mattiashellman.lexicon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeExercises {
    public static void main(String[] args) {
        // 1
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        // 2
        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.of("sv")));
        System.out.println(formattedDate.substring(0, 1).toUpperCase() + formattedDate.substring(1));

        // 3
    }
}