package core.string;

import java.util.Formatter;

/**
 * https://dzone.com/articles/java-string-format-examples
 * https://javarush.ru/quests/lectures/questmultithreading.level02.lecture06
 *
 * %d - целое число
 * %s - строка
 * %f - дробное число
 * %b - boolean
 * %c - char
 * %t - Date
 * %% - Символ %
 * %n - перевод строки
 *
 * %o - в восьмеричное системе
 * %x - в шестнадцетиричной системе
 *
 */
public class StringFormat {

    public static void main(String[] args) {
        System.out.println(String.format(" bla %d%s",5, "aaaa"));
        System.out.println(String.format("%x%o",17, 17));
        System.out.printf("My name is: %s%n", "joe");

        //Номер аргумента
        String.format("%2$s", 32, "Hello"); // prints: "Hello"

        //Формат чисел
        String.format("|%20d|", 93); // prints: |                  93|
        String.format("|%-20d|", 93); // prints: |93                  |
        String.format("|%020d|", 93); // prints: |00000000000000000093|
        String.format("|%+20d|", 93); // prints: |                 +93|
        String.format("|%,d|", 10000000); // prints: |10,000,000|

        //Formatter для StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);
        formatter.format("PI = %f", Math.PI);
        stringBuilder.append("...");
        System.out.println(stringBuilder.toString());


    }
}
