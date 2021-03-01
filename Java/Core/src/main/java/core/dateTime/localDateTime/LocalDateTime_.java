package core.dateTime.localDateTime;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * {@link LocalDateTime} -
 *
 * Статические меотоды {@link LocalDateTime}:
 * from -
 * now -
 * of -
 * ofEpochSecond - Дата от 1970.01.01 плюс количество секунд
 * ofInstant -
 * parse -
 *
 * меотоды {@link LocalDateTime}:
 * adjustInto - устанавливает время входного объекта как у текущего LocalDateTime
 * atOffset - объединяет текущий LocalDateTime со смещением
 * atZone - объединяет текущий LocalDateTime с часовым поясом
 * format - Форматирует текущий LocalDateTime, используя указанное средство форматирования.
 * get - Получает значение указанного поля
 * isAfter -
 * isBefore -
 * equals - Сравнивает этот LocalDateTime с другим, гарантируя, что дата и время совпадают. Сравниваются только объекты типа LocalDateTime, остальные типы возвращают false
 * isEqual - Этот метод учитывает только положение двух дат на местной шкале времени. Он не принимает во внимание хронологию или календарную систему.
 * compareTo - Если все сравниваемые даты и времени являются экземплярами LocalDateTime, то сравнение будет полностью основано на дате и времени. Если некоторые сравниваемые даты находятся в разных хронологиях, то также учитывается хронология
 * isSupported -
 * minus - Возвращает копию текущего LocalDateTime с вычтенным указанным значением
 * plus - Возвращает копию текущего LocalDateTime с добавленным указанным значением
 * query - Метод извлечения даты
 * range - Получает диапазон допустимых значений для указанного поля.
 * truncatedTo - Возвращает копию этого LocalDateTime с усеченным временем.
 * until - Вычисляет количество времени до другой даты
 * with - Возвращает скорректированную копию этого LocalDateTime.
 *
 */
public class LocalDateTime_ {

    public static void main(String[] args) {
        //Сеттеры
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime.from(localDateTime);
        LocalDate.of(2012, Month.DECEMBER, 12);
        LocalDate.ofEpochDay(150);  //Дата от 1970.01.01 плюс 150 дней
        LocalTime.of(17, 18);
        LocalTime.parse("10:15:30");

        //Получить миллисекунды
        LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        //Геттеры
        LocalDate theDate = localDateTime.toLocalDate();
        Month month = localDateTime.getMonth();
        int day = localDateTime.getDayOfMonth();
        localDateTime.getSecond();

        //Установка значения, возвращает новый объект
        LocalDateTime thePast = localDateTime.withDayOfMonth(10).withYear(2010);
        LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.WEEKS);

        //Сокращения
        LocalDateTime truncatedTime = localDateTime.truncatedTo(ChronoUnit.SECONDS);

        //Установка временой зоны
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);

    }
}
