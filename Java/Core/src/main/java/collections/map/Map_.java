package collections.map;


import java.util.HashMap;
import java.util.Map;

/**
 * Методы {@link Map} java 1.8 :
 *
 * compute - сделать вычисление значения для определенного ключа
 * computeIfPresent - сделать вычисление значения для определенного ключа, если он есть. Иначе возвращает null
 * computeIfAbsent - сделать вычисление значения для ключа, если его нет
 * merge - вычисляет и заменяет старое значение для определенного ключа на новое
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

        map.compute(1, (key, value) -> {
            return "compute" + value;
        });

        map.computeIfPresent(2, (key, value) -> {
            return "computeIfPresent " + key + " " + value;
        });

        map.computeIfAbsent(6, (key) -> {
            return "computeIfAbsent value " + 2;
        });

        map.merge(3, "newValue", (oldValue, newValue) -> {
            return "merge " + oldValue + " replace " + newValue;
        });

        map.getOrDefault(7, "default");

        map.forEach((key, value) -> {
            System.out.println(key + " | " + value);
        });


    }
}
