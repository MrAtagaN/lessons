package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * {@link Collection} extends {@link Iterable} - Интерфейс коллекций
 *
 * add
 * addAll
 * clear
 * contains
 * containsAll
 * isEmpty
 * parallelStream
 * remove
 * removeAll
 * removeIf
 * retainAll
 * size
 * stream
 * toArray
 * toArray
 *
 */
public class Collection_ {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.removeIf((obj) -> {return obj < 2;});
        System.out.println(list);
    }
}
