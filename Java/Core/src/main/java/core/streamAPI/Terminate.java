package core.streamAPI;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Терминальные:
 * forEach - сделать действие для каждого элемента
 * reduce - сложение элементов
 * collect - собрать в коллекцию
 * max - максимальный элемент
 * allMatch - все совпадения
 * anyMatch - хотя бы одно совпадение
 * noneMatch - никаких совпадений
 * findAny -
 * findFirst -
 *
 *
 * Методы {@link Collectors}:
 *
 *
 */
public class Terminate {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);


        //forEach
        list.forEach(elem -> {
            System.out.println(elem);
        });


        //reduce
        Integer sum = list.stream().reduce(0, (mediateSum, elem) -> mediateSum += elem);
        System.out.println("sum: " + sum);


        //collect
        List<Integer> collectList = list.stream().collect(Collectors.toList());
        Set<Integer> collectSet = list.stream().collect(Collectors.toSet());

        Double average = list.stream().collect(Collectors.averagingInt(elem -> elem));
        System.out.println("average: " + average);

        String string = Stream.of("a", "b", "c").collect(Collectors.joining(", ", "[", "]"));
        System.out.println(string);


        //allMatch
        boolean match = list.stream().allMatch(elem -> elem < 5);


        //max
        Optional<Integer> max = list.stream().max((x,y)-> x - y); //В аргумент max передать компоратор


        //findAny
        Optional<Integer> any = list.stream().findAny();


        //findFirst
        Optional<Integer> first = list.stream().findFirst();
    }
}
