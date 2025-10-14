package se.mattiashellman.lexicon;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
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
        localDate = localDate.minusWeeks(1).minusDays(localDate.getDayOfWeek().getValue() - 1);
        for (int i=0; i < 7; i++) {
            System.out.println("Day " + (i+1) + ": " + localDate.plusDays(i));
        }

        // 4
        localDate = LocalDate.parse("2025-10-13");
        System.out.println(localDate);

        // 5
        LocalDate birthday = LocalDate.parse("1982-12-02");
        DayOfWeek dayOfWeek = birthday.getDayOfWeek();
        System.out.println(dayOfWeek);

        // 6
        localDate = LocalDate.now().plusYears(10).minusMonths(10);
        System.out.println(localDate.getMonth());

        // 7
        Period period = Period.between(birthday, localDate);
        System.out.printf("%d years, %d months, %d days%n", period.getYears(), period.getMonths(), period.getDays());

        // 8
        period = Period.of(4, 7, 29);
        localDate = LocalDate.now().plus(period);
        System.out.println(localDate);

        // 9
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        // 10
        int nanoSecs = localTime.getNano();
        System.out.println(nanoSecs);

        // 11
        localTime = LocalTime.parse("16:40:33");
        System.out.println(localTime);

        // 12
        localTime = LocalTime.now();
        String formattedTime =  localTime.format(DateTimeFormatter.ofPattern("H:m:s"));
        System.out.println(formattedTime);

        // 13
        LocalDateTime localDateTime = LocalDateTime.parse("2018-04-05T10:00");
        System.out.printf("%d years, %d months, %d days %d hour %d minute %n", localDateTime.getYear(),
                localDateTime.getMonthValue(), localDateTime.getDayOfMonth(), localDateTime.getHour(), localDateTime.getMinute());

        // 14
        String formattedDateTime = localDateTime.format(DateTimeFormatter.ofPattern("EEEE d MMMM H:mm", Locale.of("sv")));
        System.out.println(formattedDateTime);

        // 15
        localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.printf("%d years, %d months, %d days %d hour %d minute %d second %n", localDateTime.getYear(), localDateTime.getMonthValue(),
                localDateTime.getDayOfMonth(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond());

        // 16
        localDateTime = LocalDateTime.now();
        localDate = localDateTime.toLocalDate();
        localTime = localDateTime.toLocalTime();
        System.out.printf("Date: %s, Time: %s", localDate.toString(), localTime.toString());

        // Calendar
        calander(2018);
    }

    private static void calander(int year) {
        System.out.println("\n\nCalendar for " + year + "\n-----------------");
        LocalDate date = LocalDate.ofYearDay(year, 1);
        for (Month month : Month.values()) {
            // print month
            System.out.println(month.name());
            // print headers
            System.out.println("Week\tMo\tTu\tWe\tTh\tFr\tSa\tSu");
            for (int currentMonth = date.getMonthValue(); currentMonth == date.getMonthValue(); ) {
                // print week
                System.out.print("  " + date.get(WeekFields.ISO.weekOfWeekBasedYear()) + "  \t");
                for (DayOfWeek weekday : DayOfWeek.values()) {
                    if (date.getDayOfWeek() != weekday) {
                        System.out.print("\t");
                    } else {
                        // print day
                        System.out.print(date.getDayOfMonth() + "\t");
                        // increment the date
                        date = date.plusDays(1);
                        // end of month
                        if (date.getDayOfMonth() == 1) break;
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}