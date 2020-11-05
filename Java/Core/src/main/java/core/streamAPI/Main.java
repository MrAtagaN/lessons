package core.streamAPI;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream API
 *
 * Промежуточные:
 * parallel - получить парралельный стрим
 * filter - оставляет элементы которые удовлетворяют условию
 * map - один объект превращает в другой
 * sorted - сортирует элементы
 * limit - первые n элементов
 * mapToInt - превращает элементы в примитивы
 *
 * Терминальные:
 * forEach - сделать действие для каждого элемента
 * reduce - сложение элементов
 * collect - собрать в коллекцию
 * max - максимальный элемент
 * allMatch - все совпадения
 * anyMatch - хотя бы одно совпадение
 * noneMatch - никаких совпадений
 *
 * Статические:
 * Stream.of() - сгенерировать стрим из элементов
 */
public class Main {

    public static void main(String[] args) {

        //Инициализация list числами от 0 до 20
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            list.add(i);
        }

        //ForkJoinPool используется в параллельных стримах (parallelStream)
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println("Количество потоков процессора: " + forkJoinPool.getParallelism() + "\r\n");


        System.out.println("Параллельный стрим, выводит элементы списка:");
        list.parallelStream().forEach(x -> System.out.print(x + " "));
        System.out.println("\r\n");


        System.out.println("Фильтр, выводит четные числа:");
        list.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.print(x + " "));
        System.out.println("\r\n");


        System.out.println("Map, умножает каждый элемент на 10:");
        list.stream().map(x -> x*10).collect(Collectors.toList()).forEach(x -> System.out.print(x + " "));
        System.out.println("\r\n");


        System.out.println("Sort, сортирует список:");
        list.stream().sorted().forEach(x -> System.out.print(x + " "));
        System.out.println("\r\n");


        System.out.println("Max, выводит максимальный элемент:\r\n" + list.stream().max((x,y) -> x-y).get());
        System.out.println();


        System.out.println("Collectors, собирает в set, list, map");
        Set<Integer> result = list.stream().map(x -> x*2).collect(Collectors.toSet());
        result.forEach(x -> System.out.print(x + " "));
        System.out.println("\r\n");


        System.out.println("FlatMap, принимает массив коллекций или массив стримов");
        Stream.of(list, result).flatMap(x -> x.stream()).forEach(x -> System.out.print(x + " "));
        System.out.println("\r\n");


        System.out.println("Reduce, складывает элементы. Identity - начальное значение, sum - сумма, elem - текущий элемент");
        System.out.println(list.stream().reduce(0, (sum, elem) -> sum += elem));
        System.out.println();


        System.out.println("Limit, первые 5 элементы");
        list.stream().limit(5).forEach(x -> System.out.print(x + " "));
        System.out.println("\r\n");


        System.out.println("MapToInt, превращает элементы в примитивы");
        list.stream().mapToInt(x -> x).forEach(x -> System.out.print(x + " "));
        System.out.println("\r\n");

        System.out.println("allMatch, возвращает true если все элементы удовлетворяют условию (<50), аналогично anyMatch, noneMatch");
        System.out.println(list.stream().allMatch(x-> x < 50));
        System.out.println();


        //Генерация стримов
        Stream.of(1, 2, 3);

        //Генерация стрима с одинаковыми объектами
        Stream.generate(() -> new String()).limit(5).count();

    }

}
