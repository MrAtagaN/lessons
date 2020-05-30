package collections.map;


import java.util.HashMap;
import java.util.Map;

/**
 * {@link Map}
 *
 * методы java 1.8 :
 *
 * compute - сделать вычисление значения для определенного ключа
 * computeIfPresent - сделать вычисление значения для определенного ключа, если он есть
 * computeIfAbsent - сделать вычисление значения для ключа, если кго нет
 * merge - вычисляет и заменяет старое значение ключа на новое
 * getOrDefault -
 */
public class Map_ {

    private static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(5, "a");
        map.put(4, "b");
        map.put(3, "c");
        map.put(2, "d");
        map.put(1, "e");
    }

    public static void main(String[] args) {
        //Методы java 1.8

        //Сделать вычисление значения для определенного ключа
        map.compute(1, (key, value) -> {
            return "compute" + value;
        });

        //Сделать вычисление значения для определенного ключа, если он есть
        map.computeIfPresent(2, (key, value) -> {
            return "computeIfPresent " + key + " " + value;
        });

        //Сделать вычисление значения для ключа, если его нет
        map.computeIfAbsent(6, (key) -> {
            return "computeIfAbsent value " + 2;
        });

        //Вычисляет и заменяет старое значение ключа на новое
        map.merge(3, "newValue", (oldValue, newValue) -> {
            return "merge " + oldValue + " replace " + newValue;
        });

        map.getOrDefault(7, "default");

        map.forEach((key, value) -> {
            System.out.println(key + " | " + value);
        });


    }
}
