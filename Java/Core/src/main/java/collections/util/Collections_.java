package collections.util;

import java.util.*;
import java.util.concurrent.*;

/**
 * {@link Collections} - Статические методы для работы с коллекциями
 *
 * Методы {@link Collections}:
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



}
