package core.streamAPI;


import java.util.Arrays;
import java.util.List;

/**
 * Промежуточные:
 * parallel - получить парралельный стрим
 * filter - оставляет элементы которые удовлетворяют условию
 * map - один объект превращает в другой
 * flatMap -
 * sorted - сортирует элементы
 * limit - первые n элементов
 * skip -
 * mapToInt - возвращает стрим из примитивов
 * distinct -
 * peek -
 * sequential -
 * unordered -
 *
 */
public class IntermediateMethods {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);

        //parallelStream
        list.parallelStream();


        //filter
        list.stream().filter(elem -> elem > 0);


        //map
        list.stream().map(elem -> {
            return elem * 2;
        });


        //sorted
        list.stream().sorted();


        //limit
        list.stream().limit(2);


        //mapToInt
        list.stream().mapToInt(elem -> elem);

    }
}
