package core.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        //accessOrder: элементы к которым был доступ, перемещаются в конец
        Map<Integer, String> map = new LinkedHashMap<>(16, 1,true);
        map.put(5, "a");
        map.put(4, "b");
        map.put(3, "c");
        map.put(2, "d");
        map.put(1, "e");

        map.get(3);

        map.forEach((key, value) -> {
            System.out.println(key + " | " + value);
        });

    }
}
