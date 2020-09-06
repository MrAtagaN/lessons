package core.generics.example0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://habr.com/ru/company/sberbank/blog/416413/
 *
 * В отличие от wildcard, переменные типа (T) могут быть ограничены только сверху (только extends).
 * Нельзя записать super.
 *
 * Множественные ограничения:
 * ограничение классом и интерфесом
 * <T extends HashMap & Comparable<? super T>
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<Integer>();
        List<? extends Number> nums = ints;
    }


    /**
     * Вы не можете добавить какой-либо объект в список <? extends T>, потому что вы не можете гарантировать,
     * на какой тип List он действительно указывает, поэтому вы не можете гарантировать, что объект разрешен в
     * этом List. Единственная «гарантия» заключается в том, что вы можете только читать с нее, и вы получите T
     * или подкласс T.
     */
    public static void main2(String[] args) {
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
        //nums.add(3.14); // compile-time error
    }

    /**
     * Вы не можете прочитать конкретный тип T (например, число) из списка <? super T> потому что вы не можете
     * гарантировать, на какой список он действительно указывает. Единственная «гарантия», которую вы имеете,
     * заключается в том, что вы можете добавить значение типа T (или любой подкласс T), не нарушая целостность
     * указанного списка.
     */
    public static <T> T getFirst(List<? super T> list) {
        // return list.get(0); // compile-time error
        return null;
    }

    /**
     * <?> означает то же что и <? extends Object>. Следовательно, согласно принципу PECS, list – это producer.
     * А producer только продюсирует элементы.
     */
    public static void reverse(List<?> list) {
        List<Object> tmp = new ArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
             //list.set(tmp.get(0)); // compile-time error
        }
    }
}
