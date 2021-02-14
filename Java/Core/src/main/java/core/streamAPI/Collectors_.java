package core.streamAPI;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.summarizingDouble;

/**
 * {@link Collectors} создает {@link Collector} который собирает входные элементы в контейнер
 *
 * https://www.baeldung.com/java-8-collectors
 *
 *
 * Методы {@link Collectors}:
 * averagingInt -
 * collectingAndThen - собрать в коллекцию, затем преобразовать
 * counting - количество элементов в стриме
 * groupingBy - группирует элементы в Map, где ключ - значение определенной функции
 * partitioningBy - группирует элементы в Map, где ключ - значение определенного предиката
 * groupingByConcurrent -
 * joining - соединяет строки
 * mapping -
 * maxBy - максимальное значение
 * reducing -
 * summarizingDouble - возвращает статистику об элементах в стриме {@link DoubleSummaryStatistics}
 * summingInt - сумма элементов
 * toCollection - собрать в коллекцию с определенной реализацией, не работает с неизменяемыми реализациями
 * toList - собрать в List, реализация разная
 * toSet - собрать в Set, реализация разная
 * toMap - собрать в Map, нужно указать KeyMapper, ValueMapper
 * toConcurrentMap -
 */
public class Collectors_ {

    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

        DoubleSummaryStatistics summarizingDouble = givenList.stream()
                .collect(summarizingDouble(String::length));

        System.out.println(summarizingDouble.getAverage()); //2.0
        System.out.println(summarizingDouble.getCount()); //4
        System.out.println(summarizingDouble.getMax()); //3.0
        System.out.println(summarizingDouble.getMin()); //1.0
        System.out.println(summarizingDouble.getSum()); //8.0

        Map<Integer, Set<String>> groupingBy = givenList.stream()
                .collect(groupingBy(String::length, toSet()));

        Map<Boolean, List<String>> partitioningBy = givenList.stream()
                .collect(partitioningBy(s -> s.length() > 2));


    }
}
