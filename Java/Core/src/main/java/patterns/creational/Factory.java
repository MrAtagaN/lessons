package patterns.creational;

import java.util.Calendar;

/**
 * Используйте паттерн Factory в следующих случаях:
 *
 * класс не имеет информации о том, какой тип объекта он должен создать;
 * класс передает ответственность по созданию объектов наследникам;
 * необходимо создать объект в зависимости от входящих данных.
 */
public class Factory {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.getClass().getCanonicalName());
    }
}
