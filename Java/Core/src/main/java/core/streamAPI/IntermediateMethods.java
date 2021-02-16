package core.streamAPI;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Промежуточные методы стримов:
 *
 * parallelStream - получить парралельный стрим
 * filter - оставляет элементы которые удовлетворяют условию
 * map - один объект превращает в другой
 * flatMap - элементы Stream<T> превращает в элементы одного потока
 * sorted - сортирует элементы
 * limit - первые n элементов
 * skip -
 * mapToInt - возвращает стрим из примитивов
 * distinct -
 * peek - действия над элементами, не меняет стрим
 * sequential -
 * unordered -
 * iterate -
 *
 */
public class IntermediateMethods {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);

        list.parallelStream();


        list.stream().filter(elem -> elem > 0);


        list.stream().map(elem -> {
            return elem * 2;
        });

        list.stream().flatMap((integer) -> {
            return Stream.of(integer);
        });

        list.stream().sorted();

        list.stream().limit(2);

        list.stream().mapToInt(elem -> elem);

        list.stream().peek(System.out::println);

    }
}
