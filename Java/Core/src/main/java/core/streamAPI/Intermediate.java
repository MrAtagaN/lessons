package core.streamAPI;


import java.util.Arrays;
import java.util.List;

/**
 * Промежуточные:
 * parallel - получить парралельный стрим
 * filter - оставляет элементы которые удовлетворяют условию
 * map - один объект превращает в другой
 * sorted - сортирует элементы
 * limit - первые n элементов
 * mapToInt - превращает элементы в примитивы
 */
public class Intermediate {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);

        //parallelStream
        list.parallelStream();


        //filter
        list.stream().filter(elem -> elem > 0);


    }
}
