package collections;

import java.util.*;
import java.util.concurrent.*;

/**
 *
 * {@link Collections} - Статические методы для работы с коллекциями
 *
 * addAll - добавить в коллекцию элементы
 * asLifoQueue - обратную очередь приводит к интерфесу Queue
 * binarySearch - поиск объекта в отсортированном массиве
 * checkedCollection, checkedMap, checkedList, checkedSet - создает коллекцию, проверяемую на этапе выполнения
 * disjoint - возвращает true, если коллекции не содержат одинаковых элементов
 * copy - копирует элементы одного списка в другой
 * frequency - количество определенных элементов в коллекции
 * indexOfSubList - индекс списка в другом списке
 * max, min - максимальное/минимальное значение в коллекции
 * nCopies - неизменяемый список из n элементов
 * newSetFromMap -
 * replaceAll - заменет все элементы в списке
 * reverse - разворачивает список
 * rotate -
 * singletonList - неизменяемый список из одного элемента
 * sort - сортировка списка
 * swap - меняет местами элементы в списке
 * synchronizedCollection - обертка, синхронизированная коллекция (устаревшия)
 * unmodifiableCollection - обертка, неизменяемая коллекция
 */
public class Collections_ {

    public static void main(String[] args) {
        Collections.asLifoQueue( new ArrayDeque());
        Collections.binarySearch( new ArrayList<String>(), "");
    }

    /***
     * Реализации List : ArrayList, LinkedList, CopyOnWriteArrayList, Vector, Stack
     */
    List arrayList = new ArrayList<>(); //List
    List copyOnWriteArrayList = new CopyOnWriteArrayList(); //List
    List linkedList = new LinkedList<>(); //List ,Queue, Deque
    List vector = new Vector(); //List
    List stack = new Stack(); //List


    /**
     * Реализации Map: HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap, ConcurrentSkipListMap
     */
    Map hashMap = new HashMap(); //Map
    Map linkedHashMap = new LinkedHashMap(); //Map
    Map treeMap = new TreeMap(); //Map
    // синхронизированные
    Map concurrentHashMap = new ConcurrentHashMap(); //Map, ConcurrentMap
    Map concurrentSkipListMap = new ConcurrentSkipListMap(); //Map, ConcurrentMap


    /**
     * Реализации Set: HashSet, LinkedHashSet, TreeSet, CopyOnWriteArraySet, ConcurrentSkipListSet
     */
    Set hashSet = new HashSet(); //Set
    Set linkedHashSet = new LinkedHashSet(); //Set
    Set treeSet = new TreeSet(); //Set, NavigableSet
    // синхронизированные
    Set copyOnWriteArraySet = new CopyOnWriteArraySet(); //Set
    Set concurrentSkipListSet = new ConcurrentSkipListSet(); //Set, NavigableSet


    /**
     * Реализации Queue: PriorityQueue, LinkedList, ArrayDeque, ArrayBlockingQueue, LinkedTransferQueue
     * PriorityBlockingQueue, LinkedBlockingQueue, SynchronousQueue
     */
    Queue priorityQueue = new PriorityQueue(); //Queue
    Queue linkedList2 = new LinkedList<>(); //List ,Queue, Deque
    Queue arrayDeque = new ArrayDeque(); //Queue, Deque
    // синхронизированные
    Queue arrayBlockingQueue = new ArrayBlockingQueue(10);
    Queue linkedTransferQueue = new LinkedTransferQueue();
    Queue priorityBlockingQueue = new PriorityBlockingQueue();
    Queue linkedBlockingQueue = new LinkedBlockingQueue();
    Queue synchronousQueue = new SynchronousQueue(); //Queue, BlockingQueue


    /**
     * Реализации Deque: ArrayDeque, LinkedList
     */
    Deque arrayDeque2 = new ArrayDeque(); //Queue, Deque
    Deque linkedList3 = new LinkedList<>(); //List ,Queue, Deque


}
