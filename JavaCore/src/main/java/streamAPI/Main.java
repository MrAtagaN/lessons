package streamAPI;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * Stream API
 */
public class Main {

    public static void main(String[] args) {

        //Инициализация list числами от 0 до 30
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i <= 30; i++) {
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

    }

}
