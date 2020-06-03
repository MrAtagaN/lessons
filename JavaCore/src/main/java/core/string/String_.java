package core.string;

/**
 * Пул строк -
 *
 * Статические
 *
 * String.copyValueOf() - new String(data)
 * String.format - форматированная строка
 * String.join - соединяет строки, вставляя между ними разделитель
 *
 *
 * Не статические:
 *
 * Подстроки:
 * trim -
 * concat - присоединяет вконец строку
 * replace -
 * substring -
 * charAt - возвращает символ на определенной позиции
 *
 * Сравнение:
 * compareTo -
 * compareToIgnoreCase -
 * contains - содержит ли строка переданное значение
 * matches - Pattern.matches(regex);
 * endsWith -
 * startsWith -
 *
 * Преобразование:
 * toCharArray -
 * getBytes -
 * split -
 *
 * Другие:
 * intern - добавить строку в пул строк
 * isEmpty -
 *
 * Коды символов:
 * codePointAt - возвращает код символа на определенной позиции
 * codePointBefore - возвращает код символа перед определенной позицией
 * codePointCount -
 * offsetByCodePoints -
 * codePoints -
 *
 *
 *
 */
public class String_ {

    public static void main(String[] args) {
        String a ="Hello";
        final String b ="Hel";
        String c ="lo";
        String d ="Hello";

        System.out.println(a == d); //true
        System.out.println(a == b + c); //false
        System.out.println(a == b + "lo"); //true

//        String.copyValueOf();
//        String.format();
//        String.join();
//
//        a.charAt();
//        a.codePointAt();
//        a.codePointBefore();
//        a.codePointCount();
//        a.codePoints();
//        a.compareTo();
//        a.compareToIgnoreCase();
//        a.concat();
//        a.contains();
//        a.intern();
//        a.matches();
//        a.offsetByCodePoints();
//        a.replace();
//        a.split();
//        a.substring();
//        a.endsWith();
//        a.getBytes();
//        a.isEmpty();
//        a.startsWith();
//        a.toCharArray();
//        a.toUpperCase();
//        a.trim();
//        a.substring();
//        a.split();

    }
}
