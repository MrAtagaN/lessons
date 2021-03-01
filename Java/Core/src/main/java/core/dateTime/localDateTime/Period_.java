package core.dateTime.localDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * {@link Period} - Учитывает календарь (летнее время)
 *
 */
public class Period_ {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        //Переоды
        Period period = Period.of(3, 2, 1);

        //Модификация даты с помощью периодов
        LocalDate oldDate = LocalDate.now();
        LocalDateTime oldDateTime = LocalDateTime.now();

        LocalDate newDate = oldDate.plus(period);
        LocalDateTime newDateTime = now.minus(period);

    }
}
