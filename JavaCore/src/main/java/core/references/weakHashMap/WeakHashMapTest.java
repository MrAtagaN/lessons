package core.references.weakHashMap;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Элементы из WeakHashMap удаляются при каждой сборке мусора
 */
public class WeakHashMapTest {

    public static void main(String[] args) {
        Map<SomeData, Integer> map = new WeakHashMap<>();

        SomeData someData = new SomeData();
        map.put(someData,90);

        someData = null;
        System.gc();

        for (int i = 0; i < 1000; i++) {
            if(map.isEmpty()) {
                System.out.println("MAP IS EMPTY!");
                break;
            } else {
                new String("a");
            }
        }

    }

    private static class SomeData {

    }
}
