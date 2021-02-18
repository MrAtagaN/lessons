package core.dateTime.localDateTime;

import java.time.Duration;
import java.time.LocalDateTime;


/**
 * {@link Duration} -
 */
public class Duration_ {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime thePast = now.withDayOfMonth(10).withYear(2010);


        //Продолжительность, различная точность
        Duration duration = Duration.between(now, thePast);
        System.out.println("Duration: " + duration);
    }
}
