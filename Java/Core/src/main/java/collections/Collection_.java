package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * https://javarush.ru/groups/posts/2308-korotko-o-glavnom---java-collections-framework
 * https://habr.com/ru/company/luxoft/blog/256877/
 * https://javarush.ru/quests/lectures/questcollections.level07.lecture09
 *
 * Реализации List : ArrayList, LinkedList, CopyOnWriteArrayList, Vector, Stack
 *
 * Реализации Map: HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap, ConcurrentSkipListMap
 *
 * Реализации Set: HashSet, LinkedHashSet, TreeSet, CopyOnWriteArraySet, ConcurrentSkipListSet
 *
 * Реализации Queue: PriorityQueue, LinkedList, ArrayDeque, ArrayBlockingQueue, LinkedTransferQueue
 * PriorityBlockingQueue, LinkedBlockingQueue, SynchronousQueue
 *
 *
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
