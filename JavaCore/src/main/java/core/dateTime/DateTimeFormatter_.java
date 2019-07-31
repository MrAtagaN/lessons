package core.dateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTimeFormatter_ {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format);

        LocalDate parse = LocalDate.parse("24/04/1989", dateTimeFormatter);
        System.out.println("parse = " + parse);
    }
}
