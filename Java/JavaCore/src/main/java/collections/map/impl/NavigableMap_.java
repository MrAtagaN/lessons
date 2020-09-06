package collections.map.impl;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * {@link NavigableMap}
 *
 * descendingMap - развернутая Map
 *
 * ceilingEntry - ближайший Entry в большую сторону
 * floorEntry - ближайший Entry в меньшую сторону
 * higherEntry - строго больший Entry
 * lowerEntry - строго меньший Entry
 *
 * pollFirstEntry - убирает первый Entry
 * pollLastEntry - убирает последний Entry
 *
 * subMap - возвращает часть Map
 * headMap - возвращает Map идущий до определенного числа
 * tailMap - возвращает Map идущий после определенного числа
 */
public class NavigableMap_ {

    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();

        map.put(1, "a");
        map.put(2, "a");
        map.put(3, "a");
        map.put(4, "a");
        map.put(5, "a");

        Map.Entry<Integer, String> integerStringEntry = map.ceilingEntry(4);
        System.out.println(integerStringEntry);

    }
}


