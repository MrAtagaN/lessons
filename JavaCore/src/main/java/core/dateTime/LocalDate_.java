package core.dateTime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class LocalDate_ {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate.of(2012, Month.DECEMBER, 12);
        LocalDate.ofEpochDay(150);  // middle of 1970
        LocalTime.of(17, 18);
        LocalTime.parse("10:15:30");

        //Геттеры
        LocalDate theDate = localDateTime.toLocalDate();
        Month month = localDateTime.getMonth();
        int day = localDateTime.getDayOfMonth();
        localDateTime.getSecond();

        //Установка значения, возвращает новый объект
        LocalDateTime thePast = localDateTime.withDayOfMonth(10).withYear(2010);

        /* You can use direct manipulation methods,
        or pass a value and field pair */
        LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.WEEKS);

        //Сокращения
        LocalDateTime truncatedTime = localDateTime.truncatedTo(ChronoUnit.SECONDS);

        // You can specify the zone id when creating a zoned date time
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zoneId.equals(ZoneId.from(zonedDateTime)));


        //Переоды
        // 3 years, 2 months, 1 day
        Period period = Period.of(3, 2, 1);

        // You can modify the values of dates using periods
        LocalDate oldDate = LocalDate.now();
        LocalDateTime oldDateTime = LocalDateTime.now();

        LocalDate newDate = oldDate.plus(period);
        ZonedDateTime newDateTime = zonedDateTime.minus(period);
        // Components of a Period are represented by ChronoUnit values
        System.out.println(period.get(ChronoUnit.DAYS) == 1);


        //Продолжительность, различная точность
        Duration duration = Duration.between(truncatedTime, oldDateTime);
        System.out.println("oneDay = " + duration);
    }
}
