package core.collections;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * https://javarush.ru/groups/posts/2308-korotko-o-glavnom---java-collections-framework
 * https://habr.com/ru/company/luxoft/blog/256877/
 *
 */
public class CollectionsTest {

    public static void main(String[] args) {
        // Collections.checkedMap()
        // Collections.disjoint()


    }

    /***
     * Реализации List
     */
    List arrayList = new ArrayList<>(); //List
    List copyOnWriteArrayList = new CopyOnWriteArrayList(); //List
    List linkedList = new LinkedList<>(); //List ,Queue, Deque
    List vector = new Vector(); //List
    List stack = new Stack(); //List


    /**
     * Реализации Set
     */
    Set hashSet = new HashSet(); //Set
    Set linkedHashSet = new LinkedHashSet(); //Set


    /**
     * Реализации Queue
     */
    Queue priorityQueue = new PriorityQueue(); //Queue
    Queue linkedList2 = new LinkedList<>(); //List ,Queue, Deque
    Queue arrayDeque = new ArrayDeque(); //Queue, Deque


    /**
     * Реализации Deque
     */
    Deque arrayDeque2 = new ArrayDeque(); //Queue, Deque
    Deque linkedList3 = new LinkedList<>(); //List ,Queue, Deque


}
