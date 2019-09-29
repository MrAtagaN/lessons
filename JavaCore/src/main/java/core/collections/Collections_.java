package core.collections;

import java.util.*;
import java.util.concurrent.*;

/**
 * https://javarush.ru/groups/posts/2308-korotko-o-glavnom---java-collections-framework
 * https://habr.com/ru/company/luxoft/blog/256877/
 * https://javarush.ru/quests/lectures/questcollections.level07.lecture09
 *
 * Методы Collections:
 *
 * addAll - добавить в коллекцию элементы
 * asLifoQueue - обратную очередь приводит к интерфесу Queue
 * binarySearch -
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
     * Реализации Map
     */
    Map hashMap = new HashMap(); //Map
    Map treeMap = new TreeMap(); //Map
    // синхронизированные
    Map concurrentHashMap = new ConcurrentHashMap(); //Map, ConcurrentMap
    Map concurrentSkipListMap = new ConcurrentSkipListMap(); //Map, ConcurrentMap


    /**
     * Реализации Set
     */
    Set hashSet = new HashSet(); //Set
    Set linkedHashSet = new LinkedHashSet(); //Set
    Set treeSet = new TreeSet(); //Set, NavigableSet
    // синхронизированные
    Set copyOnWriteArraySet = new CopyOnWriteArraySet(); //Set
    Set concurrentSkipListSet = new ConcurrentSkipListSet(); //Set, NavigableSet


    /**
     * Реализации Queue
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
     * Реализации Deque
     */
    Deque arrayDeque2 = new ArrayDeque(); //Queue, Deque
    Deque linkedList3 = new LinkedList<>(); //List ,Queue, Deque


}
