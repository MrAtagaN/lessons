package core.dateTime.localDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 *
 * Статические методы {@link DateTimeFormatter}:
 * ofPattern -
 * ofLocalizedDate -
 * parsedExcessDays -
 * parsedLeapSecond -
 *
 * методы {@link DateTimeFormatter}:
 * format -
 * parse -
 * parseBest -
 * parseUnresolved -
 * getChronology -
 * getDecimalStyle -
 * getResolverFields -
 * getLocale -
 * getZone -
 * toFormat -
 * with -
 *
 */
public class DateTimeFormatter_ {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format); //18/02/2021

        LocalDate parse = LocalDate.parse("24/04/1989", dateTimeFormatter);
        System.out.println("parse : " + parse); //parse : 1989-04-24
    }
}
