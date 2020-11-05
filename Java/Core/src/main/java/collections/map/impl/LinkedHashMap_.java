package collections.map.impl;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@link LinkedHashMap}
 *
 * Сохраняет порядок вставки или порядок доступа к ключам
 */
public class LinkedHashMap_ {

    public static void main(String[] args) {
        //accessOrder: элементы к которым был доступ(get, put), перемещаются в конец. Может использоваться как кэш
        //если false (по умолчанию), то сохраняет порядок вставки
        Map<Integer, String> map = new LinkedHashMap<>(16, 1, true);
        map.put(5, "a");
        map.put(4, "b");
        map.put(3, "c");
        map.put(2, "d");
        map.put(1, "e");

        map.get(3);
        map.get(1);
        map.get(3);
        map.put(6, "f");

        map.forEach((key, value) -> {
            System.out.println(key + " | " + value);
        });

        //Простой кэш
        SimpleLRUCache<Integer, String> cache = new SimpleLRUCache<>(2);
        cache.put(1, "");
        cache.put(2, "");
        cache.put(3, "");
        cache.get(2);
        cache.put(9, "");

        cache.keySet().forEach(System.out::println);
    }

    /**
     * Простой кэш. При переполнении удаляет элемент к которому реже был доступ
     */
    private static class SimpleLRUCache<K,V> extends LinkedHashMap<K,V> {

        private final int capacity;

        public SimpleLRUCache(int capacity) {
            super(capacity + 1, 1.1f, true);  //Мапа никогда не увеличивает свой размер
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return this.size() > capacity;  //Проверка происходит после вставки
        }
    }
}
