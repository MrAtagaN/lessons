package core.streamAPI;


import java.util.Arrays;
import java.util.List;


/**
 * Терминальные:
 * forEach - сделать действие для каждого элемента
 * reduce - сложение элементов
 * collect - собрать в коллекцию
 * max - максимальный элемент
 * allMatch - все совпадения
 * anyMatch - хотя бы одно совпадение
 * noneMatch - никаких совпадений
 */
public class Terminate {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3);


        //forEach
        list.forEach(elem -> {
            System.out.println(elem);
        });


        //reduce
        Integer sum = list.stream().reduce(0, (mediateSum, elem) -> mediateSum += elem);
        System.out.println("sum: " + sum);


        //collect



    }
}
