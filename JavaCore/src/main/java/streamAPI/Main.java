package streamAPI;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;





public class Main {

    public static void main(String[] args) {

        //Инициализация list
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        //ForkJoinPool используется в параллельных стримах
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println("Количество потоков процессора");
        System.out.println(forkJoinPool.getParallelism());

        System.out.println("Параллельный стрим");
        list.parallelStream().forEach(x -> System.out.println(x));

        System.out.println("Фильтр");
        list.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        System.out.println("Map");
        list.stream().map(x -> x*10).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("Sort");
        list.stream().sorted().forEach(System.out::println);

        System.out.println("Max");
        System.out.println( list.stream().max((x,y) -> x-y).get() );


    }

}
