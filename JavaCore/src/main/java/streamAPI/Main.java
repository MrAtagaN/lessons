package streamAPI;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;





public class Main {

    public static void main(String[] args) {

        //Инициализация list
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        //ForkJoinPool используется в параллельных стримах
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.getParallelism());

        list.parallelStream().forEach(x -> System.out.println(x));



        list.stream().filter(x -> x % 2 == 0).map(x -> x * 100).collect(Collectors.toList()).forEach(System.out::println);
    }

}
