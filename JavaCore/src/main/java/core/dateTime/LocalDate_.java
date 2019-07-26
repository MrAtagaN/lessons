package core.dateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDate_ {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

    }
}
