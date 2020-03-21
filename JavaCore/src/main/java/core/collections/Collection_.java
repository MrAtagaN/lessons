package core.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * {@link Collection}
 *
 * add(E e)
 * addAll(Collection<? extends E> c)
 * clear()
 * contains(Object o)
 * containsAll(Collection<?> c)
 * isEmpty()
 * parallelStream()
 * remove(Object o)
 * removeAll(Collection<?> c)
 * removeIf(Predicate<? super E> filter)
 * retainAll(Collection<?> c)
 * size()
 * stream()
 * toArray()
 * toArray(T[] a)
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
