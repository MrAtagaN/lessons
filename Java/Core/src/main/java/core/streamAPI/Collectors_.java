package core.streamAPI;


import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Collector;

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
 * groupingBy -
 * groupingByConcurrent -
 * joining - соединяет строки
 * mapping -
 * maxBy -
 * partitioningBy -
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

        DoubleSummaryStatistics result = givenList.stream().collect(summarizingDouble(String::length));

        System.out.println(result.getAverage()); //2.0
        System.out.println(result.getCount()); //4
        System.out.println(result.getMax()); //3.0
        System.out.println(result.getMin()); //1.0
        System.out.println(result.getSum()); //8.0


    }
}
