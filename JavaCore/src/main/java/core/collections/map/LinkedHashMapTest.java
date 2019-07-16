package core.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        // accessOrder: элементы к которым был доступ, перемещаются в конец
        // если false (по умолчанию), то сохраняет порядок вставки
        Map<Integer, String> map = new LinkedHashMap<>(16, 1, true);
        map.put(5, "a");
        map.put(4, "b");
        map.put(3, "c");
        map.put(2, "d");
        map.put(1, "e");

        // методы java 1.8

        // сделать вычисление значения для определенного ключа
        map.compute(1, (key, value) -> {
            return "compute" + value;
        });

        // сделать вычисление значения для определенного ключа, если он есть
        map.computeIfPresent(2, (key, value) -> {
            return "computeIfPresent " + key + " " + value;
        });

        // сделать вычисление значения для ключа, если кго нет
        map.computeIfAbsent(6, (key) -> {
            return "computeIfAbsent value " + 2;
        });

        // вычисляет и заменяет старое значение ключа на новое
        map.merge(3, "newValue", (oldValue, newValue) -> {
            return "merge " + oldValue + " replace " + newValue;
        });

        map.forEach((key, value) -> {
            System.out.println(key + " | " + value);
        });
    }
}
