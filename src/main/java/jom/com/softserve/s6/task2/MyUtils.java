package jom.com.softserve.s6.task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyUtils {
    public static String getDateAfterToday(int years, int months, int days) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        LocalDate dateAfterToday = today.plusYears(years).plusMonths(months).plusDays(days);

        return dateAfterToday.format(formatter);

    }
}
