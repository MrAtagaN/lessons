package collections;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * https://javarush.ru/groups/posts/2308-korotko-o-glavnom---java-collections-framework
 *
 * Реализации {@link Collection},  {@link Iterable}
 *
 * Методы Iterable:
 *
 * Iterator<T> iterator();
 * Spliterator<T> spliterator();
 * void forEach(Consumer<? super T> action)
 */
public class CollectionsImpl {

    /***
     * Реализации {@link List}
     */
    List arrayList = new ArrayList<>(); //List
    List copyOnWriteArrayList = new CopyOnWriteArrayList(); //List
    List linkedList = new LinkedList<>(); //List ,Queue, Deque
    List vector = new Vector(); //List
    List stack = new Stack(); //List


    /**
     * Set
     */
    Set hashSet = new HashSet(); //Set
    Set linkedHashSet = new LinkedHashSet(); //Set


    /**
     * Реализации {@link Queue}
     */
    Queue priorityQueue = new PriorityQueue(); //Queue
    Queue linkedList2 = new LinkedList<>(); //List ,Queue, Deque
    Queue arrayDeque = new ArrayDeque(); //Queue, Deque


    /**
     * Реализации {@link Deque}
     */
    Deque arrayDeque2 = new ArrayDeque(); //Queue, Deque
    Deque linkedList3 = new LinkedList<>(); //List ,Queue, Deque


}
